class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        root = [i for i in range(n)]
        
        def find(x):
            return root[x]
        
        def union(x, y):
            rootX = find(x)
            rootY = find(y)
            if rootX != rootY:
                for i in range(n):
                    if root[i] == rootY:
                        root[i] = rootX
        
        for edge in edges:
            union(edge[0], edge[1])
        
        
        components = set(root)
        return len(components)
        