/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node prev = null;
            Node curr = null;
            int ans = queue.size();
            for(int i=0;i<ans;i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                prev = curr;
                curr = queue.poll();
                if(prev!=null) prev.next = curr;
                curr.next = null;
                System.out.println(curr.val);
            }
            System.out.println();
        }

        return root;
    }
}