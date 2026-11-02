class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        
        if (nLen > hLen) return -1;
        
        for (int i = 0; i <= hLen - nLen; i++) {
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}

public class exercise_28 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Result 1: " + solution.strStr(haystack1, needle1));

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("Result 2: " + solution.strStr(haystack2, needle2));
    }
}