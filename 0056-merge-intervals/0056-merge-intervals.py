class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        #edge cases if i have len(intervals) == 1
        if len(intervals) == 1:
            return intervals
        
        intervals.sort()
        #define 2 pointers l and r
        # l = intervals[0] # l -->  coordinate [l1, l2]
        # r = intervals[1]
        #define result
        results = [intervals[0]]
        
        # if the second element of l is found in the range of r, then
        # create a new coordinate with first element being the fisrt ele of l
        # and second ele being second element of r
        
        for i in range(1,len(intervals)):
            if intervals[i][0] <= results[-1][1]:
                if intervals[i][1] < results[-1][1]:
                    continue
                else:
                    results[-1][1] = intervals[i][1]
            else:
                results.append(intervals[i])
        
        return results



