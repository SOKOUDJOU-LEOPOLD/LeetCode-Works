'''
Assumption: The logs is given in increasing order of the timestamp -- > This assumption was wrong
'''
class Solution:
    def earliestAcq(self, logs: List[List[int]], n: int) -> int:
        root = [i for i in range(n)]
        numGroups = n
        # print(n)
        logs.sort()
        
        def find(x):
            return root[x]
        
        def union(x, y):
            rootX = find(x)
            rootY = find(y)
            if rootX != rootY:
                for i in range(n):
                    if root[i] == rootY:
                        root[i] = rootX
                return True
            
            return False
        
        for edge in logs:
            if union(edge[1], edge[2]):
                numGroups -= 1
            if numGroups == 1:
                return edge[0]
            # print(numGroups)
        return -1
            
                    
        