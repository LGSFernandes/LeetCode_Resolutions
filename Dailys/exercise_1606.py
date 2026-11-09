import heapq
from typing import List


class Solution:
    def busiestServers(
        self,
        k: int,
        arrival: List[int],
        load: List[int]
    ) -> List[int]:

        bit = [0] + [i & -i for i in range(1, k + 1)]

        def update(index, delta):
            index += 1

            while index <= k:
                bit[index] += delta
                index += index & -index

        def prefix(end):
            result = 0

            while end > 0:
                result += bit[end]
                end -= end & -end

            return result

        def find_kth(rank):
            index = 0
            step = 1 << (k.bit_length() - 1)

            while step:
                nxt = index + step

                if nxt <= k and bit[nxt] < rank:
                    index = nxt
                    rank -= bit[nxt]

                step >>= 1

            return index

        busy = []
        count = [0] * k
        answer = []
        available_count = k
        max_requests = 0

        for i, (time, duration) in enumerate(zip(arrival, load)):
            while busy and busy[0][0] <= time:
                _, server = heapq.heappop(busy)
                update(server, 1)
                available_count += 1

            if available_count == 0:
                continue

            start = i % k
            before = prefix(start)

            rank = before + 1 if available_count > before else 1
            server = find_kth(rank)

            update(server, -1)
            available_count -= 1

            count[server] += 1
            max_requests = max(max_requests, count[server])

            heapq.heappush(busy, (time + duration, server))

        return [
            server
            for server in range(k)
            if count[server] == max_requests
        ]


solution = Solution()
print(solution.busiestServers(3, [1, 2, 3, 4, 5], [5, 2, 3, 3, 3]))
print(solution.busiestServers(3, [1, 2, 3, 4], [1, 2, 1, 2]))
print(solution.busiestServers(3, [1, 2, 3], [10, 12, 11]))