class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)
        memo = {} # (l,r) : piles[i]

        def helper(l,r):
            if r-l <= 0:
                return 0
            if (l,r) in memo:
                return memo[(l,r)]
            
            # if size of subarray piles[l:r+1] is even, then Alice play else Bob plays 
            left = helper(l+1, r) + (piles[l] if (r-l)%2 == 1 else 0)
            right = helper(l, r-1) + (piles[r] if (r-l)%2 == 1 else 0)

            memo[(l,r)] = max(left,right)
            return memo[(l,r)]

        # if there exist a verse such that alice has the greatest number of stones, then she wins
        max_ = helper(0, n-1) 
        print(max_)
        return max_ > sum(piles)//2