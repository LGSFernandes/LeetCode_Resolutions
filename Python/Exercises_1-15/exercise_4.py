class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        
        nums1.extend(nums2)
        
        nums1.sort()
        
        n = len(nums1)
        if n % 2 == 1:
            return float(nums1[n // 2])
        else:
            return (nums1[n // 2 - 1] + nums1[n // 2]) / 2.0


solution = Solution()
print(solution.findMedianSortedArrays([1, 3], [2]))
print(solution.findMedianSortedArrays([1, 2], [3, 4]))