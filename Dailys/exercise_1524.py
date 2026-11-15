from typing import List

class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        MOD = 10**9 + 7

        even_count = 1
        odd_count = 0

        prefix_parity = 0
        answer = 0

        for num in arr:
            prefix_parity ^= num & 1

            if prefix_parity == 1:
                answer += even_count
                odd_count += 1
            else:
                answer += odd_count
                even_count += 1

            answer %= MOD

        return answer


solution = Solution()
print(solution.numOfSubarrays([1, 3, 5]))
print(solution.numOfSubarrays([2, 4, 6]))