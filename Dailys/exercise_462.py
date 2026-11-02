class Solution:
    def minMoves2(self, nums: list[int]) -> int:
        nums.sort()
        median = nums[len(nums) // 2]
        return sum(abs(num - median) for num in nums)


solution = Solution()
print(solution.minMoves2([1, 2, 3]))
print(solution.minMoves2([1, 10, 2, 9]))