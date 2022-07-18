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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        if(root.left==null && root.right==null){
            sb.append(root.val);
            list.add(sb.toString());
            return list;
        }
        
        
        binaryTreePathsHelper(root,sb,list);
        return list;
        
    }
    
    public void binaryTreePathsHelper(TreeNode root,StringBuilder sb,List<String> list){
        
        if(root == null) return ;
        
        int len = sb.length();// inital length nikal li sb ki taki sb.setLength se backtracking kar sake
        
        if(root.left==null && root.right==null){
            sb.append(root.val);
            list.add(sb.toString());
            sb.setLength(len);// backtarking before return                                    
            return ;
        }       
        
        
        sb.append(root.val+"->");
        
        binaryTreePathsHelper(root.left,sb,list);
        binaryTreePathsHelper(root.right,sb,list);
        
        sb.setLength(len);// backtarking before return  
    }
        
    
}