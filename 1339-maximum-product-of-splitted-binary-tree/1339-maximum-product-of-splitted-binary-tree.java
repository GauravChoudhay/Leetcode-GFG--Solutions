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
    
    public long maxProductHelper2(TreeNode root,long total) {
        
        if(root==null) return 0l;
        if(root.left==null && root.right==null) return 0l;
        
        long max = 0;
        
        if(root.left!=null){
            max = Math.max(max,(total-root.left.val) * root.left.val);
        
            max = Math.max(max,maxProductHelper2(root.left,total));
        }
        
        if(root.right!=null){
            max = Math.max(max,(total-root.right.val) * root.right.val);
        
            max = Math.max(max,maxProductHelper2(root.right,total));
        }       
        
        
        return max ;
    }
    
    
    public int maxProduct(TreeNode root) {
        
        long total = (long) sumTree(root);
        
        long maxProduct = maxProductHelper2(root,total);
        
        return (int) (maxProduct %1000000007l);
    }
}






























