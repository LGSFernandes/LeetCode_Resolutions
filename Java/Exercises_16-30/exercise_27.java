class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

public class exercise_27 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int k = solution.removeElement(nums, val);
        
        System.out.println("k = " + k); // Expected: 5
        System.out.print("Modified array prefix: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}