class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        myDict = {}

        for i, num in enumerate(nums):
            if num in myDict:
                return[myDict[num], i]
            myDict[target-num] = i

