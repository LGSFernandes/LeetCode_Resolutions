package Dailys;

class Solution {
    public int uniquePaths(int[][] grid) {
        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;
        
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    long temp0 = dp[c + 1][1];
                    long temp1 = dp[c][0];
                    dp[c + 1][0] = temp0;
                    dp[c + 1][1] = temp1;
                } else {
                    long sum = (dp[c + 1][1] + dp[c][0]) % MOD;
                    dp[c + 1][0] = sum;
                    dp[c + 1][1] = sum;
                }
            }
        }
        
        return (int) dp[n][0];
    }
}

public class exercise_3665 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 0, 0}
        };
        int result = solution.uniquePaths(grid);

        int[][] grid_2 = {
            {0, 0},
            {0, 0}
        };
        int result_2 = solution.uniquePaths(grid_2);

        int[][] grid_3 = {
            {0, 1, 1,},
            {1, 1, 0}
        };
        int result_3 = solution.uniquePaths(grid_3);

        System.out.println("Result: " + result);
        System.out.println("Result 2: " + result_2);
        System.out.println("Result 3: " + result_3);
    }
}