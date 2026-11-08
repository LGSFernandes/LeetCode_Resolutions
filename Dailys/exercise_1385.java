import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int answer = 0;
        int m = arr2.length;

        for (int value : arr1) {
            int left = 0;
            int right = m;
            int lower = value - d;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr2[mid] < lower) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == m || arr2[left] > value + d) {
                answer++;
            }
        }

        return answer;
    }

}


public class exercise_1385 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        int result = solution.findTheDistanceValue(arr1, arr2, d);
        System.out.println(result);
    }
}