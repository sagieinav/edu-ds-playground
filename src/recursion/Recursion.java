package recursion;

public class Recursion {
    public final int NOT_FOUND = -1;

    public static int choose(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }

        if (k == n) {
            return 1;
        }

        return choose(n - 1, k - 1) + choose(n - 1, k);
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    public static int mirrorNum(int num) {
        return mirrorNumRec(num, 0);
    }

    private static int mirrorNumRec(int num, int res) {
        if (num == 0) return res;
        res = res * 10 + num % 10;
        return mirrorNumRec(num / 10, res);
    }

    public static int countNo2A(int length) {
        if (length == 0) {
            return 1;
        }
        if (length == 1) {
            return 2;
        }
        return countNo2A(length - 1) + countNo2A(length - 2);
    }

    public static void printNo2A(int length) {
        printNo2ARec(length, "");
    }

    private static void printNo2ARec(int length, String prefix) {
        if (length == 0) {
            System.out.print(prefix + ", ");
        } else {
            printNo2ARec(length - 1, prefix + 'b'); // link `b`
            if (prefix.isEmpty() || prefix.charAt(prefix.length() - 1) == 'b') {
                printNo2ARec(length - 1, prefix + 'a'); // if last letter is b, also link `a`
            }
        }
    }

    public static int fib (int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
