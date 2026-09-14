class MinStack {
    Stack<Long> st = new Stack<>();
    long min = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        long val = value * 1L;
        if (st.isEmpty()) {
            st.push(val);
            min = val;
        } else {
            if (val > min) {
                st.push(val);
            } else {
                st.push(2 * val - min);
                min = val;
            }
        }
    }
    
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        Long x = st.pop();
        if (min > x) {
            min = 2 * min - x;   
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;

        long x = st.peek();

        if (x > min) {
            return (int)(x);
        } else {
            return (int)(min);
        }
    }
    
    public int getMin() {
        return (int)(min);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */