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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        if(root==null) return list;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int s = q.size();
            
            List<Integer> nl = new ArrayList<>();
            
            while(s-->0){
                TreeNode node = q.remove();
                
                nl.add(node.val);
                
                if(node.left!=null) q.add(node.left);
                
                if(node.right!=null) q.add(node.right);
            }
            
            list.add(nl);                
                   
                   
        }
        
        return list;
    }
}



































