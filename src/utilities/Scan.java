package utilities;
import java.util.Scanner;

public class Scan {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String next() {
        return SCANNER.next();
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

    public static int nextInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static float nextFloat() {
        return Float.parseFloat(SCANNER.nextLine());
    }

    public static double nextDouble() {
        return Double.parseDouble(SCANNER.nextLine());
    }
}