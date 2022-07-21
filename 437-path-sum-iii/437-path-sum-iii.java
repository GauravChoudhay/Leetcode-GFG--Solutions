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
    
    public int dfs(TreeNode root, long tar){       
                
        if(root==null) return 0 ;
        
        int count = 0;
        if(tar==root.val) count = 1;   
                
        
        return count + dfs(root.left,tar-root.val) + dfs(root.right,tar-root.val);
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root==null) return 0;        
        
        return dfs(root,(long)targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
}




























