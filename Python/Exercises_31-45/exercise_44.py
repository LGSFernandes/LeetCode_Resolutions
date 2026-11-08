class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        n, m = len(s), len(p)

        i = j = match = 0
        star = -1

        while i < n:
            if j < m and (p[j] == '?' or p[j] == s[i]):
                i += 1
                j += 1

            elif j < m and p[j] == '*':
                star = j
                match = i
                j += 1

            elif star != -1:
                match += 1
                i = match
                j = star + 1

            else:
                return False

        while j < m and p[j] == '*':
            j += 1

        return j == m


solution = Solution()
print(solution.isMatch(s = "aa", p = "a"))
print(solution.isMatch(s = "aa", p = "*"))
print(solution.isMatch(s = "cb", p = "?a"))