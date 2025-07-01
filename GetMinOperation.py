'''
There are two operations:
• ADD_ 1: Increment the integer by 1
• MULTIPLY 2. Multiply the integer by 2
There is a list of integers, kValues. For each kValues[i], find out the minimum number of operations required to transform 0 into kValues[i] using these operations. Return a list of these results.
Example
kValues[i] = 8
Starting from 0, add 1, then multiply by 2 three times. It takes a minimum of 4 operations to get to 8, so store 4 in index 0 of the return array.
Function Description
Complete the function getMinOperations in the editor with the following parameter(s):
kValues[n]: the values to match
Returns:
order
int[n]: answers to a list of queries in the given
Constraints
• 1≤n≤ 10€
• Os kValues ≤ 1016
› Input Format for Custom Testing
• Sample Case 0
Sample Input
STDIN
Function
2
5
→
→
kValues[] size n = 2
kValues = [5, 3]
Sample Output
4
Explanation
0. To get from Oto kValues(0J = 5, ADD_1 →
MULTIPLY 2 → MULTIPLY _2 → ADD_1 to get 0 + 1 → 1x2 → 2x2 → 4 + 1=5. Because it took four operations, store 4 in index 0 of the return array.
1. To get from Oto kValues[1] = 3, ADD_1 →
MULTIPLY _2 → ADD_1 to get 0 + 1 → 1 × 2 → 2
+ 1 = 3. Because it took three operations,
store 3 in index 1 of the return array.
Return the array [4, 3] as the answer.
'''

def getMinOperations(kValues):
    res = []
    for k in kValues:
        steps = 0
        while k > 0:
            if k % 2 == 0:
                k //= 2
            else:
                k -= 1
            steps += 1
        res.append(steps)
    return res

#Test
kValues = [5, 3]
print(getMinOperations(kValues))