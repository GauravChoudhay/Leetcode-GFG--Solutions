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
    
    public void pathSumHelper(TreeNode root, int targetSum, ArrayList<Integer> path, List<List<Integer>> paths) {
        
        if(root==null) return;
        
        if(root.left==null && root.right==null && targetSum==root.val){
            path.add(root.val);
            ArrayList base = new ArrayList<>();
            
            for(int val:path){
                base.add(val);
            }
            
            paths.add(base);            
            path.remove(path.size()-1);
        }
        
        
        path.add(root.val);
        
        pathSumHelper(root.left,targetSum-root.val,path,paths);
        pathSumHelper(root.right,targetSum-root.val,path,paths);
        
        path.remove(path.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> paths = new ArrayList<>();
        
        pathSumHelper(root,targetSum,new ArrayList<>(),paths);
        return paths;
    }
}