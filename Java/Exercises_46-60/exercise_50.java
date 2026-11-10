import java.util.Scanner;

class Solution {
    public double myPow(double x, int n) {
        long power = n;

        if (power < 0) {
            x = 1.0 / x;
            power = -power;
        }

        double result = 1.0;

        while (power > 0) {
            if ((power & 1L) != 0) {
                result *= x;
            }

            x *= x;
            power >>= 1;
        }

        return result;
    }
}

public class exercise_50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();
        int n = scanner.nextInt();

        Solution solution = new Solution();

        double result = solution.myPow(x, n);

        System.out.printf("%.5f%n", result);

        scanner.close();
    }
}
