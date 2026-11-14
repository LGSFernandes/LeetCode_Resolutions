class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        cols = min(m, n)
        rows = max(m, n)

        dp = [1] * cols

        for i in range(1, rows):
            for j in range(1, cols):
                dp[j] += dp[j - 1]

        return dp[-1]


solution = Solution()
print(solution.uniquePaths(3, 7))
print(solution.uniquePaths(3, 2))