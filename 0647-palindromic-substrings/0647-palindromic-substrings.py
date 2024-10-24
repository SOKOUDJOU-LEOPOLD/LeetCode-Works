class Solution:
    def countSubstrings(self, s: str) -> int:
        counter = [0]

        def helper(i,j):
            while i>=0 and j<len(s) and s[i] == s[j]:
                counter[0] += 1
                i -= 1
                j += 1
            
        for i in range(len(s)):
            helper(i,i)
            helper(i-1,i)
            
        return counter[0]

        