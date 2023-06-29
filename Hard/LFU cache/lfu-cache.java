//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
        int capacity=sc.nextInt();
        LFUCache obj = new LFUCache(capacity);
        int runs=sc.nextInt();
        for(int i = 0;i<runs;i++){
            int s=sc.nextInt();
            if(s==1){
                int key=sc.nextInt();
                int param_1 = obj.get(key);
                System.out.println(param_1);
            }else{
                int key=sc.nextInt(),value=sc.nextInt();
                obj.put(key,value);
            }
        }
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Node {
  int key, value;
  Node prev;
  Node next;

  Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class Pair {
  int frequency;
  Node node;

  Pair(int frequency, Node node) {
    this.frequency = frequency;
    this.node = node;
  }
}

class LRUCache {
  Node tail = new Node(0, 0);
  Node head = new Node(0, 0);
  HashMap<Integer, Node> map = new HashMap<>();
  int capacity;

  LRUCache(int capacity) {
    tail.prev = head;
    head.next = tail;
    this.capacity = capacity;
  }

  Node insertAfterHead(int key, int value) {
    if (map.containsKey(key))
      return map.get(key);
    Node newNode = new Node(key, value);
    newNode.next = head.next;
    head.next.prev = newNode;
    head.next = newNode;
    newNode.prev = head;
    map.put(key, newNode);
    return newNode;
  }

  void refreshNode(Node node) {
    // first remove node and then add it to the right of head
    node.prev.next = node.next;
    node.next.prev = node.prev;
    map.remove(node.key);
    insertAfterHead(node.key, node.value);
  }

  int removeSpecificNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    map.remove(node.key);
    return node.key;
  }

  int removeLeastRUNode() {
    Node node = tail.prev;
    if (node == head)
      return -1;
    tail.prev = node.prev;
    tail.prev.next = tail;
    map.remove(node.key);
    return node.key;
  }

  int get(int key) {
    if (map.containsKey(key)) {
      refreshNode(map.get(key));
      return map.get(key).value;
    }
    return -1;
  }

  Node put(int key, int value) {
    Node newNode;
    if (map.containsKey(key)) {
      removeSpecificNode(map.get(key));
      newNode = insertAfterHead(key, value);
    } else {
      if (map.size() == capacity) {
        removeLeastRUNode();
      }
      newNode = insertAfterHead(key, value);
    }

    return newNode;
  }

  void displayDLL() {
    Node temp = tail.prev;
    while (temp.prev != null) {
      System.out.print(temp.key + "->");
      temp = temp.prev;
    }
  }

}

class LFUCache {

  TreeMap<Integer, LRUCache> map = new TreeMap<>();
  HashMap<Integer, Pair> frequencyMap = new HashMap<>();
  int capacity;

  LFUCache(int capacity) {
    this.capacity = capacity;
  }

  int get(int key) {
    if (frequencyMap.containsKey(key)) {
      int value = frequencyMap.get(key).node.value;
      put(key, value);
      return value;
    }
    return -1;
  }

  void put(int key, int value) {
    int frequency;
    if (frequencyMap.containsKey(key)) {
      frequency = frequencyMap.get(key).frequency;
      LRUCache lruCache = map.get(frequency);
      lruCache.removeSpecificNode(frequencyMap.get(key).node);
      if (lruCache.head.next == lruCache.tail)
        map.remove(frequency);
      frequency += 1;
      Node node;
      if (map.containsKey(frequency)) {
        LRUCache lruCache2 = map.get(frequency);
        node = lruCache2.put(key, value);
      } else {
        LRUCache lruCache3 = new LRUCache(capacity);
        node = lruCache3.put(key, value);
        map.put(frequency, lruCache3);
      }
      frequencyMap.put(key, new Pair(frequency, node));
    } else {
      frequency = 1;
      if (frequencyMap.size() == capacity) {
        if((map.isEmpty())){
            return;
        }
        int leastFrequency = map.firstKey();
            LRUCache lruCache = map.get(leastFrequency);
            if (lruCache.head.next == lruCache.tail)
              map.remove(frequency);
            else {
              int removedNodeKey = lruCache.removeLeastRUNode();
              if (lruCache.head.next == lruCache.tail) map.remove(frequency);
              frequencyMap.remove(removedNodeKey);
            }
      }
      Node node;
      if (map.containsKey(frequency)) {
        LRUCache lruCache2 = map.get(frequency);
        node = lruCache2.put(key, value);
      } else {
        LRUCache lruCache3 = new LRUCache(capacity);
        node = lruCache3.put(key, value);
        map.put(frequency, lruCache3);
      }
      frequencyMap.put(key, new Pair(frequency, node));
    }

  }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */