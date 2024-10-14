class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # using the monotonic stack
        stck = []
        n = len(heights)
        tot = 0
        # iterate through the heights
        for i, height in enumerate(heights):
            start = i
            # while the previous heights are smaller than the currnt height move behind and track current max area.
            while stck and height<stck[-1][1]:
                j, h = stck.pop()
                subtot = h*(i-j)
                tot = max(tot, subtot)
                start = j
            # if height is increasing append the (start_index, height) to stack
            stck.append((start, height))

        # check for all smallest height for a particular range and keep track of their max area.
        while stck:
            j, h = stck.pop()
            subtot = h*(n-j)
            tot = max(tot, subtot)
        
        return tot
                
