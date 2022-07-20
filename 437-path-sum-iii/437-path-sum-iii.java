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
    
    int count;
    
    public void nodeToAnyNodePathCount(TreeNode root, long tar){       
                
        if(root==null) return ;
        
        if(tar==root.val) count++;     
                
        
        nodeToAnyNodePathCount(root.left,tar-root.val);
        nodeToAnyNodePathCount(root.right,tar-root.val);
        return;
        
    }
    public void pathSumHelper(TreeNode root, int targetSum) {
        
        if(root==null) return ;        
        
        nodeToAnyNodePathCount(root,(long)targetSum);
        
        pathSumHelper(root.left,targetSum);
        pathSumHelper(root.right,targetSum);
        
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        
        count = 0;
        pathSumHelper(root,targetSum);
        return count;
    }
}




























