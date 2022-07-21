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
    
    public int dfs(TreeNode root, long tar, HashMap<Long,Integer> freq, long prefSum ){       
        
        
        if(root==null) return 0;
        
        prefSum+=root.val;
        
        int count = freq.getOrDefault(prefSum-tar,0);
        
        freq.put(prefSum,freq.getOrDefault(prefSum,0)+1);
        
        count += dfs(root.left,tar,freq,prefSum);
        count += dfs(root.right,tar,freq,prefSum);
        
        freq.put(prefSum,freq.getOrDefault(prefSum,0)-1);//backtrack
        
        
        return count;
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        
        HashMap<Long,Integer> freq = new HashMap<>();
        freq.put(0l,1);
        
        return dfs(root,(long)targetSum,freq,0);
        
    }
}




























