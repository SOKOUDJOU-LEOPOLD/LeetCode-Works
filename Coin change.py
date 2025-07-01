'''
322. Coin Change
Solved
Medium
Topics
conpanies icon
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 
'''

import heapq as hp
from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Use a priority queue to perform BFS: (steps taken, remaining amount)
        que = [(0, amount)]
        seen = set()  # To avoid revisiting the same amount

        while que:
            # Pop the state with the fewest steps so far
            step, node = hp.heappop(que)
            if node == 0:
                return step  # Found a solution
            if node < 0:
                continue  # Invalid state, skip
            if node in seen:
                continue  # Already visited this amount, skip
            seen.add(node)

            # Try all coin denominations
            for coin in coins:
                if node - coin not in seen:
                    hp.heappush(que, (step + 1, node - coin))
        return -1  # No solution found

if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    # Input format:
    # First line: space-separated coin denominations
    # Second line: amount
    coins = list(map(int, data[0].split()))
    amount = int(data[1])
    sol = Solution()
    print(sol.coinChange(coins, amount))


