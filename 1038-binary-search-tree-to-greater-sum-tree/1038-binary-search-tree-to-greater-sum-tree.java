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
    public TreeNode bstToGst(TreeNode root) {
        sum=0;
        rwsol(root);
        return root;
    }
    
    static int sum;
    
    public static void rwsol(TreeNode node){
        // write your code here
        if(node ==null) return;

        rwsol(node.right);
        sum += node.val;
        node.val = sum;
        rwsol(node.left);
        return;
    }
}