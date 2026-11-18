class Solution {
    public int minChanges(String s) {
        int changes = 0;

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }

        return changes;
    }
}

public class exercise_2914 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minChanges("1001"));
        System.out.println(solution.minChanges("10"));
        System.out.println(solution.minChanges("0000"));
    }
}
