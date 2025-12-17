package ex1;

public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) { // Negative can't be a palindrome
            return false;
        }

        int temp = x, original_power = 1;

        while (temp > 9) { // Find the power of x
            temp /= 10;
            original_power *= 10;
        }

        return isPalindrome(x, original_power);
    }

    private boolean isPalindrome(int x, int power) {
        if (power == 0) { // Finished going through the whole number
            return true;
        }

        if (x % 10 != x / power) { // left dig != right dig
            return false;
        }

        return isPalindrome((x % power) / 10, power / 100); // This also handles leading zeros
    }
}
