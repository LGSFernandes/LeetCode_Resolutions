import java.io.*;
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        int[][] sortedQueries = new int[q][2];

        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[n + 1];
        int[] answer = new int[q];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] query : sortedQueries) {
            int time = query[0];
            int lowerBound = time - x;

            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];

                if (count[server]++ == 0) {
                    activeServers++;
                }

                right++;
            }

            while (left < right && logs[left][1] < lowerBound) {
                int server = logs[left][0];

                if (--count[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            answer[query[1]] = n - activeServers;
        }

        return answer;
    }
}

public class exercise_2747 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int logsCount = fs.nextInt();
        int queriesCount = fs.nextInt();
        int x = fs.nextInt();

        int[][] logs = new int[logsCount][2];

        for (int i = 0; i < logsCount; i++) {
            logs[i][0] = fs.nextInt();
            logs[i][1] = fs.nextInt();
        }

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            queries[i] = fs.nextInt();
        }

        Solution solution = new Solution();

        int[] answer = solution.countServers(n, logs, x, queries);

        System.out.println(Arrays.toString(answer));
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

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int value = 0;

            while (c > ' ') {
                value = value * 10 + c - '0';
                c = read();
            }

            return value * sign;
        }
    }
}