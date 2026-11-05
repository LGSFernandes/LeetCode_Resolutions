import sys


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2

            if nums[mid] == target:
                return mid

            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1


def main():
    data = list(map(int, sys.stdin.buffer.read().split()))

    if not data:
        return

    n, target = data[0], data[1]
    nums = data[2:]

    if len(nums) != n or n < 1:
        raise ValueError("Invalid input.")

    result = Solution().search(nums, target)

    print(result)


if __name__ == "__main__":
    main()