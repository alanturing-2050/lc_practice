class MinStack {

    /** initialize your data structure here. */
    class Node {
        int val;
        Node next;
        int min;
        public Node (int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    Node head;
    public MinStack() {
        head = null;
    }

    public void push(int x) {
        if(head == null) {
            head = new Node(x, x, null);
        }
        else {
            head = new Node(x, Math.min(head.min, x), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 /**
Problem: https://leetcode.com/problems/min-stack/
Analysis:
Obviously we can use two stacks to store the min value and the current value:
Stack<Integer> regularStack => record the current Value;
Stack<Integer> minStack => record the current min Value;
TimeComplexity: O(1)
SpaceComplexity: O(N)
if not using two stacks we can use LinkedList to represent the stack
Node {
 int val;
 Node next;
 int min;
}
TimeComplexity: O(1)
SpaceComplexity: O(N)
 **/
