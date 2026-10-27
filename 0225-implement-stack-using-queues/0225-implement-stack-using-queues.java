class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        moveElements();
        int el = q1.poll();
        moveElementsBack();
        return el;
    }
    
    public int top() {
        moveElements();
        int el = q1.peek();
        q2.offer(q1.poll());
        moveElementsBack();
        return el;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }

    public void moveElements() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
    }

    public void moveElementsBack() {
        while(!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */