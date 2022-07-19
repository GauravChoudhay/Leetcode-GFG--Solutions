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
    
    public static class Pair{
        int tilt ;
        int stsum ;
        
        Pair(int tilt, int stsum){
            this.tilt = tilt;
            this.stsum = stsum;
        }
    }
    
    public Pair findTiltHelper(TreeNode root) {
        if(root==null){
            Pair base = new Pair(0,0);
            return base;
        }
        
        Pair lPair = findTiltHelper(root.left);
        Pair rPair = findTiltHelper(root.right);
        
        Pair curr = new Pair(lPair.tilt+rPair.tilt+Math.abs(lPair.stsum - rPair.stsum),  root.val+lPair.stsum + rPair.stsum);
        return curr;
        
    }
    public int findTilt(TreeNode root) {
        return findTiltHelper(root).tilt;
    }
}