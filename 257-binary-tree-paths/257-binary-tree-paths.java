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
        StringBuilder path = new StringBuilder();        
        
        binaryTreePathsHelper(root,path,list);
        return list;
        
    }
    
    public void binaryTreePathsHelper(TreeNode root,StringBuilder path,List<String> list){
        
        if(root == null) return ;
        
        int len = path.length();// inital length nikal li path ki taki path.setLength se backtracking kar sake
        path.append(root.val);
        
        if(root.left==null && root.right==null){            
            list.add(path.toString());
            path.setLength(len);// backtrsking before return                                    
            return ;
        }
        
        path.append("->");
        
        binaryTreePathsHelper(root.left,path,list);
        binaryTreePathsHelper(root.right,path,list);
        
        path.setLength(len);// backtrsking before return  
    }
        
    
}