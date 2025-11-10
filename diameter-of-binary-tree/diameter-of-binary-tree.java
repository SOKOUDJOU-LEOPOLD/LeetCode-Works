/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int val = dfs(root);
        System.out.println(val);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        // sum diameter and get max
        max = Math.max(max, left + right);
        // return the max depth
        return Math.max(left, right)+1;
        
    }
}

/*

                                   dfs(1)=2
                      dfs(2)=2                      dfs(3)=1
             dfs(4)=1             dfs(5)=1            dfs(null) dfs(null)
        dfs(null)=0   dfs(null)  dfs(null) dfs(null)
*/