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
    public boolean isBalanced(TreeNode root) {
        
        boolean[] isBal = new boolean[1];
        isBal[0]  = true;
        
        isBalanceHelper(root,isBal);
         return isBal[0];
    }
    
    private int isBalanceHelper(TreeNode root, boolean[] isBal){
        
        if(root==null) return 0;
        
        int leftHeight = isBalanceHelper(root.left,isBal);
        
        int rightHeight = isBalanceHelper(root.right,isBal);
        
        if(Math.abs(leftHeight - rightHeight)>1) isBal[0] = false;
        
        return Math.max(leftHeight,rightHeight) + 1;
    }
}