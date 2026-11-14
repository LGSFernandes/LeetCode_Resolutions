import java.util.*;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n && j - i + 1 <= r; j++) {
                sum += nums.get(j);

                int length = j - i + 1;

                if (length >= l && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}

public class exercise_3364 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSumSubarray(List.of(3, -2, 1, 4), 2, 3));
        System.out.println(solution.minimumSumSubarray(List.of(-2, 2, -3, 1), 2, 3));
        System.out.println(solution.minimumSumSubarray(List.of(1, 2, 3, 4), 2, 4));
    }
}
