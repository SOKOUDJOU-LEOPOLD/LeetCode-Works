import heapq
class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        # I will need a minimum heap
        minheap = []
        res = []

        #sort the pairs
        pairs.sort() # O(NlogN)
        count = 0

        # traverse pairs:
        for i in range(len(pairs)): # O(N)
            if minheap and pairs[i][0] > minheap[0][0] :
                e, s = heapq.heappop(minheap)  # O(logN)
                res.append([s,e]) # O(1)
                count += 1
                minheap = []


            heapq.heappush(minheap,(pairs[i][1],pairs[i][0])) # O(logN)

        if minheap:
            e, s = heapq.heappop(minheap)
            res.append([s,e])
            count+=1
        
        return count