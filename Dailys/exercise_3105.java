import java.util.Scanner;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 1;
        int decreasing = 1;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing++;
            } else {
                increasing = 1;
            }

            if (nums[i] < nums[i - 1]) {
                decreasing++;
            } else {
                decreasing = 1;
            }

            maxLength = Math.max(
                maxLength,
                Math.max(increasing, decreasing)
            );
        }

        return maxLength;
    }
}

public class exercise_3105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();

        int result = solution.longestMonotonicSubarray(nums);

        System.out.println(result);

        scanner.close();
    }
}
