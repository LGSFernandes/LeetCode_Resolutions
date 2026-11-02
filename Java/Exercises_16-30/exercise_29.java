class Solution {
    public int divide(int dividend, int divider) {
        if (dividend == Integer.MIN_VALUE && divider == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean negative = (dividend < 0) ^ (divider < 0);
        
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divider);
        
        int quotient = 0;
        
        while (dvd >= dvs) {
            long tempDvs = dvs, multiple = 1;
            while (dvd >= (tempDvs << 1)) {
                tempDvs <<= 1;
                multiple <<= 1;
            }
            dvd -= tempDvs;
            quotient += multiple;
        }
        
        return negative ? -quotient : quotient;
    }
}

public class exercise_29 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int dividend1 = 10, divider1 = 3;
        System.out.println("Result 1: " + solution.divide(dividend1, divider1)); // Expected output: 3

        int dividend2 = 7, divider2 = -3;
        System.out.println("Result 2: " + solution.divide(dividend2, divider2)); // Expected output: -2
    }
}