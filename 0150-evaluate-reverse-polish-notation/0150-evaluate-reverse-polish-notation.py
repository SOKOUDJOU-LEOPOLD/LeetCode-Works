import math

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # create list of operators
        # operators = ['+', '-', '*', '/']
        
        # create stack
        stack = []
        
        for i in range(len(tokens)):
            # print(stack)
            if tokens[i].isdecimal():
                stack.append(int(tokens[i]))
            elif len(tokens[i]) > 1 and tokens[i][0] == '-':
                stack.append(int(tokens[i]))
            else:
                if tokens[i] == '+':
                    num = stack.pop()
                    stack[-1] = stack[-1] + num
                elif tokens[i] == '-':
                    num = stack.pop()
                    stack[-1] = stack[-1] - num
                elif tokens[i] == '*':
                    num = stack.pop()
                    stack[-1] = stack[-1] * num
                elif tokens[i] == '/':
                    num = stack.pop()
                    stack[-1] = math.trunc(stack[-1] / num)
        
        return stack[0]
        
        
        
'''
U: convert string to mathematical operations
M: Stack Problem
P:
-> create a stack
-> for str that are int, push to stack. if str is operator, do operation on the last two elements of stack
-> return the result


Example:
tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
                                                   _

'''