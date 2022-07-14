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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0 ; i<inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        return getTree(preorder, inorder, 0, inorder.length-1, indexMap);
    }

    private TreeNode getTree(int[] preorder, int[] inorder, int is, int ie, HashMap<Integer, Integer> indexMap){
        if(is>ie) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        int inIndex = indexMap.get(root.val);

        root.left = getTree(preorder, inorder, is, inIndex - 1, indexMap);
        root.right = getTree(preorder, inorder, inIndex + 1, ie, indexMap);
        return root;
    }
}