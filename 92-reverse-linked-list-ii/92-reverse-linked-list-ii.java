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
    
    ListNode ch =null; // current head
    ListNode ct =null; // current tail
  
    public void addFirst(ListNode curr){
        if(ch==null){
            ch = ct = curr;
        }
        else{
            curr.next = ch;
            ch = curr;
        }
    }
  
    public ListNode reverseBetween(ListNode head, int left, int right) {
      
      if(right == left){
        return head;
      }
      
      ListNode ansH = new ListNode(-1);
      ListNode prev = ansH;
      ListNode curr = head;

      int idx=1;

      while(idx<=right+1){

          if(idx<left){
              prev.next = curr;
              prev = prev.next;
              curr = curr.next;
          }
          else if(idx>=left && idx<=right){
              //working area ->reverse using addFirst technique
              ListNode next = curr.next;

              curr.next = null;

              addFirst(curr);

              curr = next;
          }
          else if(idx>right){
              break;
          }

          idx++;
      }

      prev.next = ch;
      ct.next = curr;

      return ansH.next;          
        
    }
}