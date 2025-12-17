package well_formed_formula;

public class LogicWord {
    private char[] word;
    private String wordStr;

    public LogicWord(String word) {
        wordStr = word;
        this.word = word.toCharArray();
    }

    public boolean isWellFormed() {
        if (word.length == 0) { // Empty string
            return false;
        }
        if (!isBalancedParenthesesPrefix()) { // Performs validity checks 1+2
            return false;
        }

        return isWellFormedRec(0, word.length - 1); // Performs recursive checks
    }

    private boolean isBalancedParenthesesPrefix() {
        int left = 0, right = 0;
        for (char ch : word) {
            if (ch == '(') left++;
            else if (ch == ')') right++;

            if (right > left) return false;
        }
        return left == right;
    }

    private boolean isWellFormedRec (int start, int end) {
        if (start == end) { // Build 1 (Atomic)
            return isWellFormedAtomic(start, end);
        }

        else if (word[start] == '~') { // Build 2 (Negative)
            return isWellFormedNegative(start, end);
        }

        else if (word[start] == '(') { // Potentially Build 3 (Operator)
            return isWellFormedOperator(start, end);
        }

        else { // Starts in an illegal character
            return false;
        }
    }

    private boolean isWellFormedAtomic(int start, int end) {
        return word[start] != '~' && word[start] != '^'
                && word[start] != 'v' && word[start] != '⟹' && word[start] != '⟺';
    }

    private boolean isWellFormedNegative(int start, int end) {
        try {
            return isWellFormedRec(start + 2, end - 1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean isWellFormedOperator(int start, int end) {
        int left = 0, right = 0;
        int balance = 0;
        int mainPlace = 0;
        for (int i = start; i <= end; i++) {
            if (word[i] == '(') left++;
            else if (word[i] == ')') right++;

            if (right == left && left != 0) { // Parentheses count have just been balanced
                balance++;
                right = 0;
                left = 0;

                if (balance == 1) {
                    if (i == end) {
                        return isWellFormedRec(start + 1, end - 1);
                    }
                    else mainPlace = i + 1;
                }
                else { // balance == 2
                    if (i != end) return false; // Check 1: Balance count NOT is greater than 2

                    else if (!isOperator(word[mainPlace])) return false; // Check 2: MP is NOT an operator

                    else if (!
                            (word[mainPlace - 1] == ')' && word[mainPlace + 1] == '(')) {
                        return false; } // Check 3: Parentheses near operator are valid

                    else { // All checks passed
                        return isWellFormedRec(start + 1, mainPlace - 2) // Validate Beta
                                && isWellFormedRec(mainPlace + 2, end - 1); // Validate Gamma
                    }
                }
            }
        }
        return false; // Finished loop. Balance count is 0.
    }


    private boolean isOperator(char ch) {
        return (ch == '∧' || ch == '∨' || ch == '⟹' || ch == '⟺');
    }


    @Override
    public String toString() {
        String status = isWellFormed() ? "WFF" : "NOT WFF";
        return "Word `" + wordStr + "` is " + status;
    }
}
