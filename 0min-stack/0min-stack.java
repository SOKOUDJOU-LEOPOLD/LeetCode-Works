

import java.util.ArrayList;
import java.util.PriorityQueue;

class MinStack {
    private ArrayList<Integer> list;   // acts as stack
    private PriorityQueue<Integer> heap; // helps track minimum element

    public MinStack() {
        list = new ArrayList<>();
        heap = new PriorityQueue<>();
    }

    public void push(int val) {
        list.add(val);       // push onto stack
        heap.offer(val);     // push onto min heap
    }

    public void pop() {
        if (list.size() == 0) return;
        int val = list.remove(list.size() - 1); // pop from stack
        heap.remove(val);                        // remove from heap (O(n))
    }

    public int top() {
        if (list.size() == 0) throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1);       // last element
    }

    public int getMin() {
        if (heap.isEmpty()) throw new RuntimeException("Stack is empty");
        return heap.peek();                     // min element
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */