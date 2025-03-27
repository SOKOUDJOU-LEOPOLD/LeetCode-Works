from collections import defaultdict
from typing import List

class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        # Build the adjacency list
        adjList = defaultdict(list)
        for n1, n2 in edges:
            adjList[n1].append(n2)
            adjList[n2].append(n1)
        
        # Visited set to track visited nodes
        visited = set() 
        
        # Function to check if there is a cycle
        def hasCycle(node, parent):
            visited.add(node)  # Mark the current node as visited
            
            # Explore neighbors
            for neighbor in adjList[node]:
                # If the neighbor is visited and is not the parent, a cycle is detected
                if neighbor in visited:
                    if neighbor != parent:
                        return True
                # If the neighbor is not visited, recursively check for cycles
                else:
                    if hasCycle(neighbor, node):
                        return True
            
            return False

        # Check for a cycle starting from node 0
        if hasCycle(0, -1):
            return False
        
        # Ensure all nodes are connected (valid tree must be connected and acyclic)
        return len(visited) == n
