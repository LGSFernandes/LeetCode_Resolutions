import java.io.*;
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            int[] frequency = new int[26];

            for (int i = 0; i < str.length(); i++) {
                frequency[str.charAt(i) - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder(52);

            for (int count : frequency) {
                keyBuilder.append('#').append(count);
            }

            String key = keyBuilder.toString();

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}

public class exercise_49 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String firstLine = br.readLine();

        if (firstLine == null || firstLine.isBlank()) {
            return;
        }

        int n = Integer.parseInt(firstLine.trim());

        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            strs[i] = (line == null) ? "" : line;
        }

        Solution solution = new Solution();

        List<List<String>> result = solution.groupAnagrams(strs);

        System.out.println(result);
    }
}
