
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[0], b[0])
        );

        List<int[]> merged = new ArrayList<>();

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentEnd) {
                currentEnd = Math.max(
                    currentEnd,
                    intervals[i][1]
                );
            } else {
                merged.add(new int[]{currentStart, currentEnd});

                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }
        }

        merged.add(new int[]{currentStart, currentEnd});

        return merged.toArray(new int[merged.size()][]);
    }
}

public class exercise_56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        Solution solution = new Solution();

        int[][] result = solution.merge(intervals);

        System.out.println(Arrays.deepToString(result));

        scanner.close();
    }
}
