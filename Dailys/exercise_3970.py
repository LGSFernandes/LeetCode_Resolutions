import heapq

class Solution:
    def shortestPath(self, n: int, edges: list[list[int]], labels: str, k: int) -> int:
        graph = [[] for _ in range(n)]
        for u, v, w in edges:
            graph[u].append((v, w))
            
        dist = [[float('inf')] * (k + 1) for _ in range(n)]
        dist[0][1] = 0
        
        min_heap = [(0, 0, 1)] # (cost, node, consecutive_count)
        
        while min_heap:
            current_cost, u, cur_count = heapq.heappop(min_heap)
            
            if u == n - 1:
                return current_cost
                
            if current_cost > dist[u][cur_count]:
                continue
                
            for v, weight in graph[u]:
                next_count = cur_count + 1 if labels[v] == labels[u] else 1
                
                if next_count <= k:
                    next_cost = current_cost + weight
                    if next_cost < dist[v][next_count]:
                        dist[v][next_count] = next_cost
                        heapq.heappush(min_heap, (next_cost, v, next_count))
                        
        return -1


solution = Solution()
print(solution.shortestPath(3, [[0, 1, 1], [1, 2, 1], [0, 2, 3]], "aab", 1))
print(solution.shortestPath(3, [[0, 1, 1], [1, 2, 1], [0, 2, 3]], "aab", 2))
print(solution.shortestPath(3, [[0, 1, 1], [1, 2, 1]], "aaa", 2))