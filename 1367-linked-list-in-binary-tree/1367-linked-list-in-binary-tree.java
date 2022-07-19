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
        
        if(head==null) return true;//linked list all nodes present in tree, return tree
        if(root==null)  return false; // linked list is still remaning but root is at null, return false

        if(root.val == head.val){//if root and head values are same then check if root left or root right tree downwpath is same as head.next linked list
            if(isSamePath(head.next,root.left)) return true;// if linked list is present in left side of root node then return true no need to check else where
            
            if(isSamePath(head.next,root.right)) return true;// if linked list is present in not present in left side then check right side of root node then return true if linkedlist is present
        }

        return false;// if linked list was found alredy then it was return before meeting this line, and if recursion is approching here that means no linked List found at this path, return false
        
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        if(head==null) return true;//linked list all nodes present in tree, return tree
        if(root==null)  return false; // linked list is still remaning but root is at null, return false
        

        if(root.val==head.val){
            if(isSamePath(head,root)) return true;//if linked list is present in subtree of root node then return true no need to check elsewhere
        }
        // if root.val is not equal to head.val then we check for the linked list in ledt sub tree and right sub tree OR if root.val was equal to head.val but somehow
        // remaning linkedlist is not similar to the downward path of the the root node then also we try to check in left and right subtree
        
        if(isSubPath(head,root.left)) return true;// if linked list is present in left side of root node then return true no need to check else where       
        
        if(isSubPath(head,root.right)) return true;// if linked list is present in not present in left side then check right side of root node then return true if linkedlist is present
        
        
        return false;// if linked list was found alredy then it was return before meeting this line, and if recursion is approching here that means no linked List found at this path, retun false
        
    }
}
























