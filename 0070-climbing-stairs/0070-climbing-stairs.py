class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0 for i in range(n+1)]
        dp[n]=1
        dp[n-1]=1

        for i in range(n-2,-1,-1):
            dp[i] = dp[i+1] + dp[i+2]
        
        return dp[0]
        
        





'''

I have a max number of stairs n 
I have only 2 choices: 1 or 2


                        0
                1 /           \ 2
                 1             2
        1   /        \ 2    1/     \2
           2           3    3       4 


      5  4  3  2  1  0 
1     3  3  2  2  1  1
                    
2     0  1  0  1  0  1      <---
      0  0  0  0  0  1      


'''
         

        