class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # ***********lets test probable TLE answer O(n^2)************
        # ans = []
        # n = len(temperatures)
        # for i in range(n):
        #     j = i+1
        #     while j<n  and temperatures[i] >= temperatures[j]:
        #         j += 1
        #     if j==n:
        #         ans.append(0)
        #     else:
        #         ans.append(j-i)
        
        # return ans

        # ********* Using the monotonic decreasing stack**************
        n = len(temperatures)
        res = [0]*n
        stack = []

        #iterating through the temperatures
        for i in range(n):
            if not stack:
                stack.append((temperatures[i], i))
            else:
                while stack and temperatures[i] > stack[-1][0]:
                    t, j = stack.pop()
                    res[j] = i-j
                stack.append((temperatures[i], i))
        return res

            










