import java.io.*;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[3];

        for (int i = 1; i <= n; i++) {
            int best = dp[(i - 1) % 3] + 1;

            if (i >= 2) {
                best = Math.min(best, dp[(i - 2) % 3] + 4);
            }

            if (i >= 3) {
                best = Math.min(best, dp[(i - 3) % 3] + 9);
            }

            dp[i % 3] = costs[i - 1] + best;
        }

        return dp[n % 3];
    }
}

public class exercise_3693 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] costs = new int[n];

        for (int i = 0; i < n; i++) {
            costs[i] = fs.nextInt();
        }

        Solution solution = new Solution();

        System.out.println(solution.climbStairs(n, costs));
    }

    private static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int value = 0;

            while (c > ' ') {
                value = value * 10 + c - '0';
                c = read();
            }

            return value;
        }
    }
}