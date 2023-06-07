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
    public ListNode middleNode(ListNode head) {
        ListNode t = head;
        int count = 0;
        while(t!=null){
            count++;
            t = t.next;
        }
        int mid = ((1+count)/2) + ((1+count)%2);
        count = 1;
        t = head;
        while(t!=null && count!=mid){
            t=t.next;
            count++;
        }
        return t; 
    }
}