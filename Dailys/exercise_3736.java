class Solution {
    public int minMoves(int[] nums) {
        int maxVal = nums[0];
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        int moves = 0;
        for (int num : nums) {
            moves += (maxVal - num);
        }
        
        return moves;
    }
}

public class exercise_3736 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {2, 1, 3};
        System.out.println("Result 1: " + solution.minMoves(nums1));

        int[] nums2 = {4, 4, 5};
        System.out.println("Result 2: " + solution.minMoves(nums2));
    }
}