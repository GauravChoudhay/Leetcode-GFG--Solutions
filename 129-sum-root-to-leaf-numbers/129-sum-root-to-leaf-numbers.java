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
    
    public void sumNumbersHelper(TreeNode root, int rtl,int[] ans){
        
        
        rtl = rtl*10 + root.val;
        
        if(root.left==null && root.right ==null){       
            ans[0]+=rtl;
        }        
        
        if(root.left!=null){
            sumNumbersHelper(root.left,rtl,ans);
        }
        
        if(root.right!=null){
            sumNumbersHelper(root.right,rtl,ans);
        }
        
        rtl = rtl/10; // backtrack
    }
    public int sumNumbers(TreeNode root) {
        
        int[] ans = new int[1];//to avoid global varibale we make array of 1 size
        
        sumNumbersHelper(root,0,ans);
        return ans[0];
        
    }
}