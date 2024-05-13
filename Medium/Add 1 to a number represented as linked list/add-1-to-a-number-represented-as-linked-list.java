//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/
class Solution
{
    static Node reverse(Node head){
        Node f = null;
        Node s = head;
        Node t = null;
        while(s!=null){
            t = s.next;
            s.next = f;
            f = s;
            s = t;
        }
        return f;
    }
    public static Node addOne(Node head) 
    { 
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while(temp != null){
            if(carry == 0) break;
            int sum = temp.data + carry;
            if(sum > 9) carry = 1;
            else carry = 0;
            temp.data = (sum) % 10;
            if(temp.next == null && carry == 1){
                temp.next = new Node(1);
                break;
            }
            temp = temp.next;
        }
        head = reverse(head);
        return head;
    }
}
