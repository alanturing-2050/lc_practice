class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }
    Node head;
    Node tail;
    int capacity;
    int count;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap();
        this.capacity = capacity;
        count = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        remove(cur);
        addToHead(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        if(capacity <= 0) return;
        Node cur = map.get(key);
        if(cur == null) {
            cur = new Node();
            cur.key = key;
            cur.value = value;
            map.put(key, cur);
            count++;
        }
        else {
            cur.value = value;
            remove(cur);
        }
        addToHead(cur);
        if(count > capacity) {
            Node last = tail.pre;
            remove(last);
            map.remove(last.key);
            count--;
        }
    }

    public void addToHead(Node cur) {
        Node next = head.next;
        head.next = cur;
        cur.pre = head;
        cur.next = next;
        next.pre = cur;
    }

    public void remove(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.next = null;
        cur.pre = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


 /**
Problem:https://leetcode.com/problems/lru-cache/
Analysis:
becuase we need O(1) TimeComplexity operation
we need to implement double linked list so we can each time updating the recent one
Notice: for put method don't use containsKey, use get if(cur == null)
TimeComplexity: O(1)
SpaceComplexity: O(N)
tag: #DoubleLinkedList 
