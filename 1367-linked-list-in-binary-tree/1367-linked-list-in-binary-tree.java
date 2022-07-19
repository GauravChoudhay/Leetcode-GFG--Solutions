/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    
    public boolean isSamePath(ListNode head, TreeNode root){
        
        if(head==null) return true;
        
                    
        head = head.next;

        if(head==null) return true;

        if(root.left != null && root.left.val == head.val){
            if(isSamePath(head,root.left)) return true;
        }

        if(root.right != null &&root.right.val == head.val){
            if(isSamePath(head,root.right)) return true;
        }

        return false;
        
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        

        if(root!=null && root.val==head.val){
            if(isSamePath(head,root)) return true;
        }
        
        if(root.left!=null){
            if(isSubPath(head,root.left)) return true;
        }
        
        if(root.right!=null){
            if(isSubPath(head,root.right)) return true;
        }
        
        return false;
        
    }
}
























