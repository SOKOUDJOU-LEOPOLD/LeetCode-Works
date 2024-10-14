class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stck = []
        n = len(heights)
        tot = 0
        for i, height in enumerate(heights):
            start = i
            while stck and height<stck[-1][1]:
                j, h = stck.pop()
                subtot = h*(i-j)
                tot = max(tot, subtot)
                start = j
            
            stck.append((start, height))

        while stck:
            j, h = stck.pop()
            subtot = h*(n-j)
            tot = max(tot, subtot)
        
        return tot
                
