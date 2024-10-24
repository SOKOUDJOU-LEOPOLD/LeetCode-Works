# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:

        max_sum = [0]
        # print(max_sum["count"])
        def dfs(root):
            if not root:
                return -1
            
            left_height = 1+dfs(root.left)
            right_height = 1+dfs(root.right)
            max_sum[0] = max(max_sum[0], left_height + right_height)

            return max(left_height, right_height)
        
        dfs(root)
        return max_sum[0]


'''
==> The start and end of the longest path is not neccesarily on different sides of the root node.
==> key idea: find the depth of the right subtree of the root and find the   depth of the left subtree of the root
'''
        
'''
        1
      /   \
     2     3
    / \              
   4   5
'''
 