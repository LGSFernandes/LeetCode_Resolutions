from typing import List

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        dp = [0] * n
        dp[0] = grid[0][0]

        for j in range(1, n):
            dp[j] = dp[j - 1] + grid[0][j]

        for i in range(1, m):
            dp[0] += grid[i][0]

            for j in range(1, n):
                dp[j] = min(dp[j], dp[j - 1]) + grid[i][j]

        return dp[n - 1]

    
solution = Solution()
print(solution.minPathSum([[1,3,1],[1,5,1],[4,2,1]]))
print(solution.minPathSum([[1,2,3],[4,5,6]]))