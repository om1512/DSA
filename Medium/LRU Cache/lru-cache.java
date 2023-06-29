//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
  class Node {
    int key, value;
    Node prev;
    Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  Node tail = new Node(0, 0);
  Node head = new Node(0, 0);
  HashMap<Integer, Node> map = new HashMap<>();
  int capacity;

  LRUCache(int capacity) {
    tail.prev = head;
    head.next = tail;
    this.capacity = capacity;
  }

  void insertAfterHead(int key, int value) {
    if (map.containsKey(key))
      return;
    Node newNode = new Node(key, value);
    newNode.next = head.next;
    head.next.prev = newNode;
    head.next = newNode;
    newNode.prev = head;
    map.put(key, newNode);
  }

  void refreshNode(Node node) {
    // first remove node and then add it to the right of head
    node.prev.next = node.next;
    node.next.prev = node.prev;
    map.remove(node.key);
    insertAfterHead(node.key, node.value);
  }

  void removeSpecificNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    map.remove(node.key);
  }

  void removeLeastRUNode() {
    Node node = tail.prev;
    if (node == head)
      return;
    tail.prev = node.prev;
    tail.prev.next = tail;
    map.remove(node.key);
  }

  int get(int key) {
    if (map.containsKey(key)) {
      refreshNode(map.get(key));
      return map.get(key).value;
    }
    return -1;
  }

  void set(int key, int value) {

    if (map.containsKey(key)) {
      removeSpecificNode(map.get(key));
      insertAfterHead(key, value);
    } else {
      if (map.size() == capacity) {
        removeLeastRUNode();
      }
      insertAfterHead(key, value);
    }
  }
}
