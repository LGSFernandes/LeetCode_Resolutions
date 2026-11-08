import heapq
from typing import List


class Solution:
    def assignTasks(self, servers: List[int], tasks: List[int]) -> List[int]:
        available = [(weight, i) for i, weight in enumerate(servers)]
        heapq.heapify(available)

        busy = []
        answer = [0] * len(tasks)
        current_time = 0

        for i, duration in enumerate(tasks):
            current_time = max(current_time, i)

            while busy and busy[0][0] <= current_time:
                _, index = heapq.heappop(busy)
                heapq.heappush(available, (servers[index], index))

            if not available:
                current_time = busy[0][0]

                while busy and busy[0][0] <= current_time:
                    _, index = heapq.heappop(busy)
                    heapq.heappush(available, (servers[index], index))

            _, index = heapq.heappop(available)

            answer[i] = index

            heapq.heappush(
                busy,
                (current_time + duration, index)
            )

        return answer


solution = Solution()
print(solution.assignTasks(servers = [3,3,2], tasks = [1,2,3,2,1,2]))
print(solution.assignTasks(servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]))