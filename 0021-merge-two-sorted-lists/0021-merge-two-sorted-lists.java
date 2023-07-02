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
    ListNode head = null;
    ListNode last = null;
    void insertNode(int data){
        ListNode node = new ListNode(data);
        if(head==null){
            head = node;
            last = node;
            return;
        }   
        last.next = node;
        last = node;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                insertNode(list1.val);
                list1 = list1.next;
            }else{
                insertNode(list2.val);
                list2 = list2.next;
            }
        }
        while(list1!=null){
            insertNode(list1.val);
            list1 = list1.next;
        }
        while(list2!=null){
            insertNode(list2.val);
            list2 = list2.next;
        }

        return head;
    }
}