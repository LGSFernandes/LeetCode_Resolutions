import bisect

class Solution:
    def minOperations(self, nums: list[int], x: int, k: int) -> int:
        n = len(nums)
        
        costs = [float('inf')] * n
        lower = []
        upper = []
        lower_sum = 0
        upper_sum = 0

        for i in range(n):
            val = nums[i]
            if not lower or val <= lower[-1]:
                idx = bisect.bisect_right(lower, val)
                lower.insert(idx, val)
                lower_sum += val
            else:
                idx = bisect.bisect_right(upper, val)
                upper.insert(idx, val)
                upper_sum += val

            if i >= x:
                out_val = nums[i - x]
                if out_val <= lower[-1]:
                    idx = bisect.bisect_left(lower, out_val)
                    lower.pop(idx)
                    lower_sum -= out_val
                else:
                    idx = bisect.bisect_left(upper, out_val)
                    upper.pop(idx)
                    upper_sum -= out_val

            while len(lower) < len(upper):
                val = upper.pop(0)
                lower.append(val)
                lower.sort()
                lower_sum += val
                upper_sum -= val
            while len(lower) - len(upper) > 1:
                val = lower.pop()
                upper.insert(0, val)
                upper.sort()
                upper_sum += val
                lower_sum -= val

            if i >= x - 1:
                median = lower[-1]
                cost = (median * len(lower) - lower_sum) + (upper_sum - median * len(upper))
                costs[i - x + 1] = cost

        memo = {}
        def dp(idx, rem_k):
            if rem_k == 0:
                return 0
            if idx + rem_k * x > n:
                return float('inf')
            if (idx, rem_k) in memo:
                return memo[(idx, rem_k)]
            
            skip = dp(idx + 1, rem_k)
            pick = costs[idx] + dp(idx + x, rem_k - 1)
            
            memo[(idx, rem_k)] = min(skip, pick)
            return memo[(idx, rem_k)]

        return dp(0, k)

solution = Solution()
print(solution.minOperations([5, -2, 1, 3, 7, 3, 6, 4, -1], 3, 2))
print(solution.minOperations([9, -2, -2, -2, 1, 5], 2, 2))