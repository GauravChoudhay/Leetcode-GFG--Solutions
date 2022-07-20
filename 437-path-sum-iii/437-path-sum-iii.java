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
    
    public void pathSumHelper(TreeNode root, long tar){       
                
        if(root==null) return ;
        
        if(tar==root.val) count++;     
                
        
        pathSumHelper(root.left,tar-root.val);
        pathSumHelper(root.right,tar-root.val);
        return;
        
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        
        
        if(root==null) return 0;        
        
        count = 0;    
        pathSumHelper(root,(long)targetSum);
        int Ocount = count;
        count = 0;
        
        Ocount+= pathSum(root.left,targetSum);
        Ocount+= pathSum(root.right,targetSum);
        
        return Ocount;
    }
}




























