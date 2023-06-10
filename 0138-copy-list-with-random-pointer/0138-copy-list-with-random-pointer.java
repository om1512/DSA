/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp  =head;
        Node f = head;
        while(temp!=null){
            Node n = new Node(temp.val);
            f = temp.next;
            temp.next = n;
            n.next = f;
            temp = f;
        }
        temp = head;
        while(temp!=null){
            if(temp.random!=null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        Node dummy = new Node(0);
        Node intr = head;
        Node copy = dummy;
        Node front = head;
        while(intr!=null){
            front = intr.next.next;
            copy.next = intr.next;
            intr.next = front;
            copy = copy.next;
            intr = front;
        }
        return dummy.next;
    }
}