import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        if (sLen < totalLen) {
            return result;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seenMap = new HashMap<>();
            int count = 0;

            while (right + wordLen <= sLen) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(sub)) {
                    seenMap.put(sub, seenMap.getOrDefault(sub, 0) + 1);
                    count++;

                    while (seenMap.get(sub) > wordMap.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        seenMap.put(leftSub, seenMap.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    seenMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}

public class exercise_30 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println("Result 1: " + solution.findSubstring(s1, words1));

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println("Result 2: " + solution.findSubstring(s2, words2));
    }
}