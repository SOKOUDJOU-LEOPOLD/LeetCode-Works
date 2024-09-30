class Solution:
    def minCut(self, s: str) -> int:
        # n = len(s)
        
        # # Step 1: Create a 2D table to store palindrome information
        # isPalindrome = [[False] * n for _ in range(n)]
        
        # # Initialize the palindrome table
        # for i in range(n):
        #     isPalindrome[i][i] = True  # A single character is always a palindrome
        
        # # Check palindromes of length 2 or more
        # for length in range(2, n + 1):  # length of the substring
        #     for i in range(n - length + 1):
        #         j = i + length - 1
        #         if s[i] == s[j]:
        #             if length == 2 or isPalindrome[i + 1][j - 1]:
        #                 isPalindrome[i][j] = True
        
        # # Step 2: Create a dp array where dp[i] is the minimum cuts for substring s[0:i+1]
        # dp = [float('inf')] * n
        # for i in range(n):
        #     if isPalindrome[0][i]:  # No cuts needed if s[0:i+1] is already a palindrome
        #         dp[i] = 0
        #     else:
        #         # Check possible cuts
        #         for j in range(1, i + 1):
        #             if isPalindrome[j][i]:  # If s[j:i+1] is a palindrome
        #                 dp[i] = min(dp[i], dp[j - 1] + 1)
        
        # # The last element of dp will give the answer
        # return dp[n - 1]
        n = len(s)
        
        # dp[i] will store the minimum cuts needed for substring s[0:i+1]
        dp = [i for i in range(n)]
        
        # Helper function to expand around the center and calculate minimum cuts
        def expandAroundCenter(left: int, right: int):
            while left >= 0 and right < n and s[left] == s[right]:
                # If it's a palindrome, check and update dp[right]
                if left == 0:
                    dp[right] = 0  # No cuts needed if the whole substring is a palindrome
                else:
                    dp[right] = min(dp[right], dp[left - 1] + 1)
                # print((left, right),dp)
                left -= 1
                right += 1
        
        # Try to find all palindromes with each center
        for i in range(n):
            # Check for odd-length palindromes centered at i
            expandAroundCenter(i, i)
            
            # Check for even-length palindromes centered between i and i+1
            expandAroundCenter(i, i + 1)
        
        # The last element of dp will give the minimum cuts for the whole string
        return dp[n - 1]