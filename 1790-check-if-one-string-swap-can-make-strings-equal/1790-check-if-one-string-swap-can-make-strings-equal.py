class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        if len(s1) == len(s2):
            # memo = []
            memo1 = []
            memo2 = []
            count = 0
            for i in range(len(s1)):
                if s1[i] != s2[i]:
                    count += 1
                    if not memo1 and not memo2:
                        memo1.append(s1[i])
                        memo2.append(s2[i])
                    else:
                        if s1[i] in memo2 and s2[i] in memo1:
                            continue
                        else:
                            return False
                
                if count > 2:
                    return False
            
        else:
            return False


        if (count > 0 and count < 2) or count>2:
            return False
        return True
        