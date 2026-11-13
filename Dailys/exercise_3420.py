from collections import deque
from typing import List

class Solution:
    def countNonDecreasingSubarrays(
        self,
        nums: List[int],
        k: int
    ) -> int:
        answer = 0
        cost = 0

        dq = deque()

        j = len(nums) - 1

        for i in range(len(nums) - 1, -1, -1):
            num = nums[i]
            count = 1

            # Merge blocks with smaller adjusted values.
            while dq and dq[-1][0] < num:
                next_num, next_count = dq.pop()

                count += next_count

                cost += (num - next_num) * next_count

            dq.append((num, count))

            # Shrink the window while the cost exceeds k.
            while cost > k:
                rightmost_num, rightmost_count = dq.popleft()

                cost -= rightmost_num - nums[j]

                j -= 1

                if rightmost_count > 1:
                    dq.appendleft(
                        (rightmost_num, rightmost_count - 1)
                    )

            answer += j - i + 1

        return answer


solution = Solution()
print(solution.countNonDecreasingSubarrays([6, 3, 1, 2, 4, 4], 7))
print(solution.countNonDecreasingSubarrays([6, 3, 1, 3, 6], 4))