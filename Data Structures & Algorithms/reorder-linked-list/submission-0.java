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
    public void reorderList(ListNode head) {
        //pahle middle
        ListNode slow= head , fast= head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }
        //last wale middle part  ko reverse kr do
        ListNode prev=null, curr= slow.next;
        slow.next=null;
        while(curr!=null){
            ListNode next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //merge kr dete hai pahle wale part ko  and second (reversed) part ko
        ListNode first=head, second = prev;
        while(second!=null){
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;
        }
        
    }
}
