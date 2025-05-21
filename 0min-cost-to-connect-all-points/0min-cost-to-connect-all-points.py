import heapq

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        visited = [False] * n
        minHeap = [(0, 0)]  # (cost, point index)
        total_cost = 0
        edges_used = 0

        while edges_used < n:
            cost, u = heapq.heappop(minHeap)
            if visited[u]:
                continue
            visited[u] = True
            total_cost += cost
            edges_used += 1

            # Check all neighbors and push into heap
            for v in range(n):
                if not visited[v]:
                    dist = abs(points[u][0] - points[v][0]) + abs(points[u][1] - points[v][1])
                    heapq.heappush(minHeap, (dist, v))

        return total_cost
