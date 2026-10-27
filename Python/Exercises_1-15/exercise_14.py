class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs:
            return ""

        first_word = strs[0]
        
        for i, letter in enumerate[str](first_word):
            for other_str in strs[1:]:
                if i >= len(other_str) or other_str[i] != letter:
                    
                    return first_word[:i]
                    
        return first_word

solution = Solution()
print(solution.longestCommonPrefix(["flower", "flow", "flight"]))
print(solution.longestCommonPrefix(["dog", "racecar", "car"]))