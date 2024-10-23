from collections import defaultdict
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        #track the rightmost occurence
        dicto = {char:i for i, char in enumerate(s)} # O(N)

        stack = []
        # seen = set()   # 290/290

        # for i, char in enumerate(s): # O(N)
        #     if char not in seen:
        #         while stack and char < stack[-1] and i < dicto[stack[-1]]:
        #             seen.discard(stack.pop())
                
        #         seen.add(char)
        #         stack.append(char)

        # return "".join(stack) # O(N)
        seen = defaultdict(bool)

        for i in range(len(s)):  #290/290
            if not seen[s[i]]:
                while stack and stack[-1]>s[i]:
                    if i < dicto[stack[-1]]:
                        seen[stack[-1]] = False
                        stack.pop()
                    else:
                        break
                        
                seen[s[i]] = True
                stack.append(s[i])
        
        return "".join(stack)

        # for i in range(len(s)):  #290/290
        #     if not seen[s[i]]:
        #         while stack and stack[-1][0]>s[i]:
        #             if i < dicto[stack[-1][0]]:
        #                 seen[stack[-1][0]] = False
        #                 stack.pop()
        #             else:
        #                 break
                
        #         seen[s[i]] = True
        #         stack.append((s[i],i))
        
        # res = ""
        # for coor in stack:
        #     res+=coor[0]
        # return res






        # we use a monotonic increasing stck.  score 275/290
        # stack = []
        # n = len(s)
        
        # for i in range(n):
        #     if stack and s[i] in stack:
        #         ind = stack.index(s[i])
        #         if ind + 1 <len(stack):
        #             if stack[ind+1]<stack[ind]:
        #                 stack.pop(ind)
        #             else:
        #                 continue
        #         else:
        #             continue
        #     stack.append(s[i])
        
        # return "".join(stack)

