from collections import defaultdict
from typing import List
'''
Union Find: Union by Rank with path compression

'''
class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        n = len(s)
        parent = list(range(n))
        rank = [1] * n

        # Find with Path Compression
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])  # Path compression
            return parent[x]

        # Union by Rank
        def union(x, y):
            rootX = find(x)
            rootY = find(y)
            if rootX != rootY:
                if rank[rootX] > rank[rootY]:
                    parent[rootY] = rootX
                elif rank[rootX] < rank[rootY]:
                    parent[rootX] = rootY
                else:
                    parent[rootY] = rootX
                    rank[rootY] += 1

        # Step 1: Connect components
        for a, b in pairs:
            union(a, b)

        # Step 2: Group connected components
        # list of values in groups are in sorted order
        groups = defaultdict(list)
        for i in range(n):
            groups[find(i)].append(i)

        # Step 3: Sort each group and place characters accordingly
        res = list(s)
        for indices in groups.values():
            chars = sorted(res[i] for i in indices)  # Extract and sort characters
            for i, char in zip(indices, chars):
                res[i] = char  # Place sorted characters in correct positions

        return "".join(res)
