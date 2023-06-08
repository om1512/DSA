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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp =head;
        ListNode evenHead = null;
        ListNode evenPoint = null;
        ListNode oddHead = null;
        ListNode oddPoint = null;
        int count = 0;
        while(temp != null){
            count++;
            if(count%2 != 0){
                if(oddHead == null){
                oddHead = temp;
                oddPoint = temp;
                }else{
                oddPoint.next = temp;
                oddPoint = oddPoint.next;
                }
            }else{
                if(evenHead == null){
                evenHead = temp;
                evenPoint = temp;
                }else{
                evenPoint.next = temp;
                evenPoint = evenPoint.next;
                }
            }
            temp = temp.next;
        }
        if(oddHead == null || evenHead == null) return head;
        oddPoint.next = evenHead;
        evenPoint.next = null;
        return oddHead;
    }
}