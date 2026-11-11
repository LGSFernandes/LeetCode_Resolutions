
import java.util.Scanner;

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}

public class exercise_55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();

        boolean result = solution.canJump(nums);

        System.out.println(result);

        scanner.close();
    }
}
