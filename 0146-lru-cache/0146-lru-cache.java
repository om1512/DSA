public class LRUCache {
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

  void put(int key, int value) {

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