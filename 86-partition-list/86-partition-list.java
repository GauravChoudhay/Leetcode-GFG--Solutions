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
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode sh = new ListNode(-1); //smaller head
        ListNode gh = new ListNode(-1); //greater head

        ListNode st = sh; //smaller tail
        ListNode gt = gh; //greater

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                st.next = curr;
                st = st.next;
            } 
            else if (curr.val >= x) {
                gt.next = curr;
                gt = gt.next;
            }
            curr = curr.next;
        }

        st.next = gh.next;
        gt.next = null;

        return sh.next;
    }
}