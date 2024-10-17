import sys
sys.set_int_max_str_digits(0) # to increase the limit for integer string conversion in line 19
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        # match --> monotonically increasing stack
        stck = [num[0]]
        counter = 0
        for i in range(1,len(num)):
            while stck and counter < k and int(num[i]) < int(stck[-1]):
                stck.pop()
                counter+=1
            
            stck.append(num[i])
        
        while counter < k:
            stck.pop(-1)
            counter+=1
        
        return str(int("".join(stck) if stck else "0"))
                

                


        