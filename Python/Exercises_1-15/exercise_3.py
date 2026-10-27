class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        saw = {}
        start = 0
        bigger = 0

        for i, char in enumerate(s):
            if char in saw and saw[char] >= start:
                start = saw[char] + 1

            saw[char] = i
            bigger = max(bigger, i - start + 1)

        return bigger


solution = Solution()
print(solution.lengthOfLongestSubstring("abcabcbb"))
print(solution.lengthOfLongestSubstring("bbbbb"))
print(solution.lengthOfLongestSubstring("pwwkew"))
