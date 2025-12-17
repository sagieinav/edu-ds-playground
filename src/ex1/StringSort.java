package ex1;

public class StringSort {
    public String sortString(String inputString) { // O(n)
        StringBuilder sb = new StringBuilder();
        char[] chArr = inputString.toCharArray();
        int[] smallCh = new int[26];
        int[] bigCh = new int[26];
        int letter;

        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] < 97) { // UPPERCASE
                letter = chArr[i] - 65;
                bigCh[letter]++;
            }
            else { // lowercase
                letter = chArr[i] - 97;
                smallCh[letter]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (bigCh[i] != 0) {
                sb.append((char) (i + 65));
                bigCh[i]--;
            }
            while (smallCh[i] != 0) {
                sb.append((char) (i + 97));
                smallCh[i]--;
            }
        }
        return sb.toString();
    }


/*    public String sortStringSel(String inputString) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = inputString.toCharArray();
        int min_idx;
        char temp, current, minChar;

        for (int i = 0; i < chArr.length; i++) {
            min_idx = i;
            for (int j = i; j < chArr.length; j++) {
                current = Character.toLowerCase(chArr[j]);
                minChar = Character.toLowerCase(chArr[min_idx]);
                if (current < minChar) {
                    min_idx = j;
                }
            }
            temp = chArr[i];
            chArr[i] = chArr[min_idx];
            chArr[min_idx] = temp;
            sb.append(chArr[i]);
        }
        return sb.toString();
    }*/


/*    public String sortStringSelRaw(String inputString) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = inputString.toCharArray();
        int min_idx;
        char temp;

        for (int i = 0; i < chArr.length; i++) {
            min_idx = i;
            for (int j = i; j < chArr.length; j++) {
                if ((chArr[j] < 97 && chArr[min_idx] < 97) || (chArr[j] >= 97 && chArr[min_idx] >= 97)) { // Same case
                    if (chArr[j] < chArr[min_idx]) {
                        min_idx = j;
                    }
                }
                else if (chArr[j] < 97) { // j is UPPERCASE, min_idx is lowercase
                    if (chArr[j] + 32 < chArr[min_idx]) {
                        min_idx = j;
                    }
                }
                else { // j is lowercase, min_idx is UPPERCASE
                    if (chArr[j] < chArr[min_idx] + 32) {
                        min_idx = j;
                    }
                }
            }
            temp = chArr[i];
            chArr[i] = chArr[min_idx];
            chArr[min_idx] = temp;
            sb.append(chArr[i]);
        }
        return sb.toString();
    }*/
}
