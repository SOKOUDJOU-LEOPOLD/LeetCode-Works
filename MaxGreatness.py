'''
2592. Maximize Greatness of an Array
Attempted
Medium
Topics
conpanies icon
Companies
Hint
You are given a 0-indexed integer array nums. You are allowed to permute nums into a new array perm of your choosing.

We define the greatness of nums be the number of indices 0 <= i < nums.length for which perm[i] > nums[i].

Return the maximum possible greatness you can achieve after permuting nums.

 

Example 1:

Input: nums = [1,3,5,2,1,3,1]
Output: 4
Explanation: One of the optimal rearrangements is perm = [2,5,1,3,3,1,1].
At indices = 0, 1, 3, and 4, perm[i] > nums[i]. Hence, we return 4.
Example 2:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We can prove the optimal perm is [2,3,4,1].
At indices = 0, 1, and 2, perm[i] > nums[i]. Hence, we return 3.
 

'''

class Solution:
    def maximizeGreatness(self, nums: list[int]) -> int:
        perm = nums[:]
        counter = 0
        #Method 1: without sorting 
        # i = 0
        # while i < len(nums)-1:
        #     j = i+1
        #     while j < len(nums):
        #         #Swap
        #         if nums[i] < perm[j]:
        #             tmp = perm[i]
        #             perm[i] = perm[j]
        #             perm[j] = tmp
        #             counter+=1
        #             break
        #         j+=1
        #     i+=1

        # print(perm)
        #Method 2: using sorting
        perm.sort() # O(nlogn)
        i = 0
        while i<len(nums):
            j = i
            while j < len(nums):
                #Swap
                if nums[i] < perm[j]:
                    tmp = perm[i]
                    perm[i] = perm[j]
                    perm[j] = tmp
                    counter += 1
                    rest = perm[i+1:]
                    rest.sort()
                    perm = perm[:i+1] + rest
                    break
                j+=1
            i+=1
        # print(perm)
        
        return counter
    
    # Optimized O(n log n) two-pointer solution
    def maximizeGreatness_optimized(self, nums: list[int]) -> int:
        nums_sorted = sorted(nums)
        perm_sorted = sorted(nums)
        n = len(nums)
        i = j = res = 0
        while i < n and j < n:
            if perm_sorted[j] > nums_sorted[i]:
                res += 1
                i += 1
            j += 1
        return res
