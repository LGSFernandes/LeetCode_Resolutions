import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        final int INF = 1_000_000_000;

        int[][] cost = new int[n][n];

        // Precompute the minimum cost for every substring.
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end < n; end++) {
                int length = end - start + 1;
                int best = length;

                for (int d = 1; d < length; d++) {
                    if (length % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    for (int offset = 0; offset < d; offset++) {
                        int groupLength = (length - 1 - offset) / d + 1;

                        for (int pair = 0; pair < groupLength / 2; pair++) {
                            int left = start + offset + pair * d;

                            int right = start + offset
                                      + (groupLength - 1 - pair) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[start][end] = best;
            }
        }

        // DP: dp[p][i] = minimum cost to partition s[0..i-1] into p parts.
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            for (int end = 2 * parts; end <= n; end++) {
                for (int start = 2 * (parts - 1); start <= end - 2; start++) {
                    if (dp[parts - 1][start] == INF) {
                        continue;
                    }

                    dp[parts][end] = Math.min(
                        dp[parts][end],
                        dp[parts - 1][start] + cost[start][end - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}


public class exercise_2911 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumChanges("abcac", 2));
        System.out.println(solution.minimumChanges("abcdef", 2));
        System.out.println(solution.minimumChanges("aabbaa", 3));
    }
}