class Node {
    int val;
    Node prev;
    Node next;
    int key;
    public Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    int capacity;
    int size;
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.head = new Node (0,0);
        this.tail = new Node (0,0);
        this.head.next = this.tail;
        this.tail.prev= this.head;
    }
    
    public int get(int key) {
        if (!this.cache.containsKey(key)) return -1;
        Node temp = cache.get(key);
        remove(temp);
        insertAtFront(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        Node temp;
        if (this.cache.containsKey(key)) {
           temp = cache.get(key);
           temp.val = value;
           remove(temp);
        } else {
            if (size == capacity) {
                removeFromLast();
                size--;
            } 
            temp = new Node (key, value);
            cache.put(key, temp);
            size++;
        }
        insertAtFront(temp);
    }
    private void remove (Node temp) {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
    }
    private void insertAtFront (Node temp) {
            temp.prev = head;
            temp.next = head.next;
            head.next.prev = temp;
            head.next = temp;
    }
    private void removeFromLast() {
            Node lastNode = tail.prev;
            tail.prev = lastNode.prev;
            lastNode.prev.next = tail;
            cache.remove(lastNode.key);
    }    
}
