'''
Question:
You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. Initially, all the cells of grid are water cells (i.e., all the cells are 0's).

We may perform an add land operation which turns the water at position into a land. You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.

Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1,1,2,3]
Explanation:
Initially, the 2d grid is filled with water.
- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
Example 2:

Input: m = 1, n = 1, positions = [[0,0]]
Output: [1]
 

Constraints:

1 <= m, n, positions.length <= 104
1 <= m * n <= 104
positions[i].length == 2
0 <= ri < m
0 <= ci < n
 

Follow up: Could you solve it in time complexity O(k log(mn)), where k == positions.length?

'''

# # Solution 1
# # Using Union-Find 162/162 but slow time complexity O(k.m.n)
class UnionFind:
    def __init__(self, m, n):
        # m: rows
        # n: cols
        self.root = [0]*(m*n)
        for i in range(m):
            for j in range(n):
                self.root[(n*i)+j]  = (n*i)+j
            
    # find the root node
    def find(self, x):
        return self.root[x]
    
    # Link 2 nodes
    def union(self, x, y):
        # get the root for x and y
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX != rootY:
            for i in range(len(self.root)):
                if self.root[i] == rootY:
                    self.root[i] = rootX
    
    # Say if 2 nodes are connected. 2 nodes are connected if they have the same root
    def connected(self, x, y):
        return self.find(x) == self.find(y)

class Solution:
    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        # creating the Union Find object and setting up the root
        UFObj = UnionFind(m, n)
        # create grid
        grid = [[0 for i in range(n)] for j in range(m)]
        # print(grid)
        def getNode(x, y, n):
            return (n*x)+y
        def isNewLand(x, y, m, n):
            directions = [(0,1),(0,-1),(1,0), (-1,0)]
            sett =set()
            Y = getNode(x,y,n)
            # count the number of different lands
            count = 0
            for dx, dy in directions:
                nx = x+dx
                ny = y+dy
                if 0 <= nx < m and 0 <= ny < n:
                    if grid[nx][ny] == 1:
                        X = getNode(nx, ny, n)
                        if not UFObj.connected(X, Y):
                            
                            count += 1
                            UFObj.union(X, Y) 
            return -(count-1)
             
        curr_total = 0
        res = []
        visited = set()
        for pos in positions:
            if (pos[0],pos[1]) not in visited:
                visited.add((pos[0],pos[1]))
                grid[pos[0]][pos[1]] = 1
                curr_total += isNewLand(pos[0], pos[1], m, n)
            res.append(curr_total)
            
        return res 



# # Solution 2
# # Using Union-Find-Rank 162/162 with Fast time complexity O(k.α(m.n)) ≈ O(k)
# class UnionFind:
#     def __init__(self, m, n):
#         size = m * n
#         self.root = [i for i in range(size)]
#         self.rank = [1] * size   # ✅ added rank
    
#     def find(self, x):
#         if self.root[x] != x:   # ✅ path compression
#             self.root[x] = self.find(self.root[x])
#         return self.root[x]
    
#     def union(self, x, y):
#         rootX = self.find(x)
#         rootY = self.find(y)
#         if rootX != rootY:
#             if self.rank[rootX] > self.rank[rootY]:
#                 self.root[rootY] = rootX
#             elif self.rank[rootX] < self.rank[rootY]:
#                 self.root[rootX] = rootY
#             else:
#                 self.root[rootY] = rootX
#                 self.rank[rootX] += 1
    
#     def connected(self, x, y):
#         return self.find(x) == self.find(y)

# class Solution:
#     def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
#         UFObj = UnionFind(m, n)
#         grid = [[0 for _ in range(n)] for _ in range(m)]
        
#         def getNode(x, y, n):
#             return (n * x) + y
        
#         def isNewLand(x, y, m, n):
#             directions = [(0,1),(0,-1),(1,0),(-1,0)]
#             Y = getNode(x, y, n)
#             count = 0
#             for dx, dy in directions:
#                 nx, ny = x + dx, y + dy
#                 if 0 <= nx < m and 0 <= ny < n:
#                     if grid[nx][ny] == 1:
#                         X = getNode(nx, ny, n)
#                         if not UFObj.connected(X, Y):
#                             count += 1
#                             UFObj.union(X, Y)
            
#             return -(count - 1)
        
#         curr_total = 0
#         res = []
#         visited = set()
#         for r, c in positions:
#             if (r, c) not in visited:
#                 visited.add((r, c))
#                 grid[r][c] = 1
#                 curr_total += isNewLand(r, c, m, n)
#             res.append(curr_total)
        
#         return res
