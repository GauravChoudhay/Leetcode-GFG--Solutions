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
    
     
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null){//iski need nahi hai wese bcz 1 node to hogi hi constrain hai
            return 0;
        }
        
        int[] dia = new int[1];
        
        diameterOfBinaryTreeHelper(root,dia);
        return dia[0];
    }
    
    public int diameterOfBinaryTreeHelper(TreeNode root,int[] dia){
        
        if(root==null){
            return -1;
        }
        
        int lheight = diameterOfBinaryTreeHelper(root.left,dia);
        int rheight = diameterOfBinaryTreeHelper(root.right,dia);
        
        int ndia = lheight+rheight+2;
        
        if(ndia>dia[0]){
            dia[0] = ndia;
        }
        
        return Math.max(lheight,rheight)+1;
        
    }
}