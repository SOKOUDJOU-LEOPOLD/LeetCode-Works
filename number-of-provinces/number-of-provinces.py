'''
Idea: Union Find 
Quick Find Approach
'''
from collections import defaultdict
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        #creating a graph of agency list
        n = len(isConnected)
        graph = set()
        for i in range(n):
            for j in range(n):
                if isConnected[i][j] == 1:
                    if (i,j) in graph or (j,i) in graph:
                        continue
                    graph.add((i,j))
        print(graph)

        root = [i for i in range(n)]
        # find the root node            
        def find(node):
            return root[node]
        
        #Link nodes in the graphs
        def union(x, y):
            rootX = find(x)
            rootY = find(y)

            if rootX != rootY:
                for i in range(len(isConnected)):
                    if root[i] == rootY:
                        root[i] = rootX

        # traverse the graph to link nodes
        for coor in graph:
            union(coor[0], coor[1])
        
        # reduce the roots to one occurrences
        sett = set(root)
        
        return len(sett)
        