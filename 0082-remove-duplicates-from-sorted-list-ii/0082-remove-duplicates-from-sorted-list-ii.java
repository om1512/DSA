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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = new ListNode();
        ListNode dummy = prev;
        dummy.next = slow;
        while(fast != null){
            if(slow.val == fast.val){
                while(fast != null && slow.val == fast.val){
                    slow = slow.next;
                    fast = fast.next;
                }
                slow = slow.next;
                if(fast!=null){
                    fast = fast.next;
                }
                prev.next = slow;
            }else{
                prev = prev.next;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}