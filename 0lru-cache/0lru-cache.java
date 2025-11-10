// DLL
class Node{
    public int key;
    public int val;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    HashMap<Integer, Node> cache;
    int cap;
    Node head = new Node(-1, -1);
    Node tail = new Node(-2, -2);

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void insert(Node node){
        Node before_tail = this.tail.prev;
        before_tail.next = node;
        node.prev = before_tail;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        // create a new one or I update it.
        Node node;
        if(cache.containsKey(key)){
            node = cache.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }

        node = new Node(key, value);
        cache.put(key, node);
        insert(node);
        if(cache.size() > this.cap){
            node = this.head.next;
            remove(node);
            cache.remove(node.key);
        }
        
    }
}

/*
cap = 2
cache = {
    3:3
    4:4
}




*/





/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */