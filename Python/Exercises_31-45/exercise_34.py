class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        n = len(nums)
        left, right = 0, n

        while left < right:
            mid = left + (right - left) // 2

            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid

        first = left

        if first == n or nums[first] != target:
            return [-1, -1]

        left, right = first, n

        while left < right:
            mid = left + (right - left) // 2

            if nums[mid] <= target:
                left = mid + 1
            else:
                right = mid

        return [first, left - 1]


solution = Solution()
print(solution.searchRange([5, 7, 7, 8, 8, 10], 8))
print(solution.searchRange([5, 7, 7, 8, 8, 10], 6))