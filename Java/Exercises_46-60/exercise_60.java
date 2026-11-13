import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--;

        StringBuilder result = new StringBuilder(n);

        for (int i = n; i >= 1; i--) {
            int blockSize = factorial[i - 1];

            int index = k / blockSize;

            result.append(numbers.remove(index));

            k %= blockSize;
        }

        return result.toString();
    }
}


public class exercise_60 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
        System.out.println(solution.getPermutation(4, 9));
        System.out.println(solution.getPermutation(3, 1));
    }
}