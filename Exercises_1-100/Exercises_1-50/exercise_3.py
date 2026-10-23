class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        visto = {}
        inicio = 0
        maior = 0

        for i, char in enumerate(s):
            if char in visto and visto[char] >= inicio:
                inicio = visto[char] + 1

            visto[char] = i
            maior = max(maior, i - inicio + 1)

        return maior


solution = Solution()
print(solution.lengthOfLongestSubstring("abcabcbb"))
print(solution.lengthOfLongestSubstring("bbbbb"))
print(solution.lengthOfLongestSubstring("pwwkew"))
