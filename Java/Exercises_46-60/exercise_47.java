import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, path, result);

        return result;
    }

    private void backtrack(
        int[] nums,
        boolean[] used,
        List<Integer> path,
        List<List<Integer>> result
    ) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);

            backtrack(nums, used, path, result);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}


public class exercise_47 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        List<List<Integer>> result = solution.permuteUnique(nums);
        List<List<Integer>> result2 = solution.permuteUnique(nums2);
        System.out.println(result);
        System.out.println(result2);
    }
}