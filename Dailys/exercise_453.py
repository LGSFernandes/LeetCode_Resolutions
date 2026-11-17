from typing import List

class Solution:
    def minMoves(self, nums: List[int]) -> int:
        min_value = min(nums)
        total = sum(nums)

        return total - len(nums) * min_value


solution = Solution()
print(solution.minMoves([1, 2, 3]))
print(solution.minMoves([1, 1, 1]))