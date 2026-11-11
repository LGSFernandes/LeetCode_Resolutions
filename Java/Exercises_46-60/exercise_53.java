
import java.util.Scanner;

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public int maxSubArrayDivideConquer(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftBest = divide(nums, left, mid);
        int rightBest = divide(nums, mid + 1, right);

        int sum = 0;
        int leftSuffix = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSuffix = Math.max(leftSuffix, sum);
        }

        sum = 0;
        int rightPrefix = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightPrefix = Math.max(rightPrefix, sum);
        }

        int crossBest = leftSuffix + rightPrefix;

        return Math.max(
            Math.max(leftBest, rightBest),
            crossBest
        );
    }
}

public class exercise_53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();

        int kadaneResult = solution.maxSubArray(nums);
        int divideResult = solution.maxSubArrayDivideConquer(nums);

        System.out.println("Kadane: " + kadaneResult);
        System.out.println("Divide and Conquer: " + divideResult);

        scanner.close();
    }
}
