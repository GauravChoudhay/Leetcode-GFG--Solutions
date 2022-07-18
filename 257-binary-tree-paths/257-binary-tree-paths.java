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
        
        if(root.left==null && root.right==null){
            list.add(root.val+"");
            return list;
        }
        
        
        binaryTreePathsHelper(root,"",list);
        return list;
        
    }
    
    public void binaryTreePathsHelper(TreeNode root,String str,List<String> list){
        
        if(root == null) return ;
        
        if(root.left==null && root.right==null){
            str+= root.val;
            list.add(str);
            return ;
        }
        
        
        str+= root.val+"->";
        
        binaryTreePathsHelper(root.left,str,list);
        binaryTreePathsHelper(root.right,str,list);
    }
        
    
}