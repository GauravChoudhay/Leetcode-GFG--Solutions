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
    
    public int sumTree(TreeNode root) {
        
        if(root==null) return 0;        
        root.val += sumTree(root.left) +sumTree(root.right); ;
        return root.val;
    }
    
    public long maxProductHelper(TreeNode root,long total) {
        
        if(root==null) return 0l;
        if(root.left==null && root.right==null) return 0l; //if its a leaf node there is no edge generating form it so no need to check anything jsut return 
        
        long max = 0l;
        
        if(root.left!=null){
            max = Math.max(max,(total-root.left.val) * root.left.val);// checking if my left edge is having maxproduct
        
            max = Math.max(max,maxProductHelper(root.left,total));// checking if my left subtree has any edge having max product 
        }
        
        if(root.right!=null){
            max = Math.max(max,(total-root.right.val) * root.right.val);// checking if my right edge is having maxproduct
        
            max = Math.max(max,maxProductHelper(root.right,total));// checking if my right subtree has any edge having max product 
        }       
        
        
        return max ;
    }
    
    
    public int maxProduct(TreeNode root) {
        
        long total = (long) sumTree(root);
        
        long maxProduct = maxProductHelper(root,total);
        
        return (int) (maxProduct %1000000007l);
    }
}






























