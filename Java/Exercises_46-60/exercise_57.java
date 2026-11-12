
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // Phase 1: Add intervals before the new interval.
        while (i < n && intervals[i][1] < newStart) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge overlapping intervals.
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }

        result.add(new int[]{newStart, newEnd});

        // Phase 3: Add remaining intervals.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}

public class exercise_57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        int[] newInterval = new int[2];

        newInterval[0] = scanner.nextInt();
        newInterval[1] = scanner.nextInt();

        Solution solution = new Solution();

        int[][] result = solution.insert(intervals, newInterval);

        System.out.println(Arrays.deepToString(result));

        scanner.close();
    }
}
