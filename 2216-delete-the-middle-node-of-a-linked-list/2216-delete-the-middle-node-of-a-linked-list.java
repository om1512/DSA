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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        int count = 1;
        ListNode t = head;
        while(t.next!=null){
            t = t.next;
            count++;
        }
        int mid = ((1+count)/2) + ((1+count)%2);
        count = 1;
        t = head;
        ListNode prev= null;
        while(t!=null){
            if(count == mid) {
                prev.next=t.next;
                return head;
            }
            prev = t;
            t = t.next;
            count++;
        }
        return head;
    }
}