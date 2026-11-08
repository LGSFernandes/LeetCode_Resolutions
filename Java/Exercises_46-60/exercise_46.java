import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result);

        return result;
    }

    private void backtrack(
        int[] nums,
        int start,
        List<List<Integer>> result
    ) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>(nums.length);

            for (int value : nums) {
                permutation.add(value);
            }

            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);

            backtrack(nums, start + 1, result);

            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


public class exercise_46 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int[] nums2 = {0, 1};
        List<List<Integer>> result = solution.permute(nums);
        List<List<Integer>> result2 = solution.permute(nums2);
        System.out.println(result);
        System.out.println(result2);
    }
}