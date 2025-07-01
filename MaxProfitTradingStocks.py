'''
2291. Maximum Profit From Trading Stocks
Medium
Topics
conpanies icon
Companies
Hint
You are given two 0-indexed integer arrays of the same length present and future where present[i] is the current price of the ith stock and future[i] is the price of the ith stock a year in the future. You may buy each stock at most once. You are also given an integer budget representing the amount of money you currently have.

Return the maximum amount of profit you can make.

 

Example 1:

Input: present = [5,4,6,2,3], future = [8,5,4,3,5], budget = 10
Output: 6
Explanation: One possible way to maximize your profit is to:
Buy the 0th, 3rd, and 4th stocks for a total of 5 + 2 + 3 = 10.
Next year, sell all three stocks for a total of 8 + 3 + 5 = 16.
The profit you made is 16 - 10 = 6.
It can be shown that the maximum profit you can make is 6.
Example 2:

Input: present = [2,2,5], future = [3,4,10], budget = 6
Output: 5
Explanation: The only possible way to maximize your profit is to:
Buy the 2nd stock, and make a profit of 10 - 5 = 5.
It can be shown that the maximum profit you can make is 5.
Example 3:

Input: present = [3,3,12], future = [0,3,15], budget = 10
Output: 0
Explanation: One possible way to maximize your profit is to:
Buy the 1st stock, and make a profit of 3 - 3 = 0.
It can be shown that the maximum profit you can make is 0.
 

Constraints:

n == present.length == future.length
1 <= n <= 1000
0 <= present[i], future[i] <= 100
0 <= budget <= 1000


'''

from typing import List

class Solution:
    def maximumProfit(self, present: List[int], future: List[int], budget: int) -> int:
        n = len(present)
        dp = [0] * (budget + 1)
        for i in range(n):
            profit = future[i] - present[i]
            if profit <= 0:
                continue  # skip stocks with no profit
            cost = present[i]
            for b in range(budget, cost - 1, -1):
                dp[b] = max(dp[b], dp[b - cost] + profit)
        return max(dp)

    def maximumProfit_recursive(self, present: List[int], future: List[int], budget: int) -> int:
        n = len(present)
        def dfs(i, remaining):
            if i == n or remaining <= 0:
                return 0
            profit = future[i] - present[i]
            # Option 1: skip this stock
            res = dfs(i + 1, remaining)
            # Option 2: buy this stock (if profitable and affordable)
            if profit > 0 and present[i] <= remaining:
                res = max(res, profit + dfs(i + 1, remaining - present[i]))
            return res
        return dfs(0, budget)
    

if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    n = int(data[0])
    present = list(map(int, data[1].split()))
    future = list(map(int, data[2].split()))
    budget = int(data[3])
    sol = Solution()
    print(sol.maximumProfit(present, future, budget))