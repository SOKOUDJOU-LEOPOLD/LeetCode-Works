class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # defining my variables
        n = len(nums)
        stack = [] # (num[i],i)
        res = ['1']*n #
        changed = [False]*n #list boolean

        # traverse the array
        for i in range(2*n):
            while stack  and stack[-1][0] < nums[i%n]:
                if not changed[stack[-1][1]%n]:
                    res[stack[-1][1]%n] = nums[i%n]
                    changed[stack[-1][1]%n] = True
                
                stack.pop()
            
            stack.append((nums[i%n],i%n))

        # 2nd traversal to remove the string '1' from result
        for i in range(n):
            if res[i] == "1":
                res[i] = -1
        
        return res


