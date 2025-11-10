/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public boolean find(TreeNode node, TreeNode root, ArrayList<TreeNode> path){
        if(root == null){
            return false;
        }
        
        path.add(root);
        // System.out.println(root.val);
        if(root == node){
            return true;
        }
        
        if(find(node, root.left, path) || find(node, root.right, path)){
            return true;
        }
        
        path.remove(root);
        return false;
    }
    
    ArrayList<TreeNode> pathP = new ArrayList<>();
    ArrayList<TreeNode> pathQ = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        System.out.println("path P");
        find(p, root, this.pathP);
        System.out.println("path Q");
        find(q, root, this.pathQ);
        
        int minL = Math.min(pathP.size(), pathQ.size());
        int i;
        for(i = 0; i<minL; i++){
            if(pathP.get(i) != pathQ.get(i)){
                break;
            }
        }
        
        return pathP.get(i-1);
        
    }
//     public boolean find(ArrayList<TreeNode> path, TreeNode node, TreeNode target){
//         if(node == null){
//             return false;
//         }
//         path.add(node);
//         if(node == target){
//             return true;
//         }
        
//         if(find(path, node.left, target) || find(path, node.right, target)){
//             return true;
//         }

//         path.remove(path.size()-1);

//         return false;

//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         ArrayList<TreeNode> pathp = new ArrayList<>();
//         ArrayList<TreeNode> pathq = new ArrayList<>();
//         find(pathp, root, p);
//         find(pathq, root, q);

//         TreeNode[] path1 = pathp.toArray(new TreeNode[0]);
//         TreeNode[] path2 = pathq.toArray(new TreeNode[0]); 

//         int n = Math.min(path1.length, path2.length);
//         System.out.println("n: "+n);
//         int i = 0;
//         for(i=0; i<n;i++){
//             if(path1[i] != path2[i]){
//                 break;
//             }
//         }
//         return path1[i-1];

//     }
}