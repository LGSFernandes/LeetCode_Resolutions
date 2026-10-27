class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

solution = Solution()
print(solution.twoSum([1, 8, 52, 23, 10], 9))
print(solution.twoSum([3, 5, 1, 7], 10))