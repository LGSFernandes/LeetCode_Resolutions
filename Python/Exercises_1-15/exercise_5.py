class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        def expandir(esq: int, dir: int) -> str:
            while esq >= 0 and dir < len(s) and s[esq] == s[dir]:
                esq -= 1
                dir += 1
            return s[esq + 1 : dir]

        bigger = ""
        for i in range(len(s)):
            odd = expandir(i, i)
            even = expandir(i, i + 1)

            if len(odd) > len(bigger):
                bigger = odd
            if len(even) > len(bigger):
                bigger = even

        return bigger

solution = Solution()
print(solution.longestPalindrome("babad"))
print(solution.longestPalindrome("cbbd"))