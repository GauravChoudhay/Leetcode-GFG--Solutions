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
    public int minDepth(TreeNode root) {
        
        if(root==null) return 0;// agar ek bhi node nahi  hai tree mai
        
        return minDepthHelper(root);
    }
    
    public int minDepthHelper(TreeNode root) {
        
        if(root==null) return Integer.MAX_VALUE;// single child hoga to hi aayega is condition pr
            
        if(root.left==null && root.right==null) return 1; // leaf node
        
        
        return Math.min(minDepthHelper(root.left), minDepthHelper(root.right)) + 1;
    }
}