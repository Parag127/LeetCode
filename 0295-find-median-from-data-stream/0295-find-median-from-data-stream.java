class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min =  new PriorityQueue<>(Collections.reverseOrder());
        max =  new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        min.offer(num);

        if (!max.isEmpty() && min.peek() > max.peek()) {
            int a = max.poll();
            int b = min.poll();

            max.offer(b);
            min.offer(a);
        }        
        if (min.size() > max.size() + 1) {
            max.offer(min.poll());
        }

        if (max.size() > min.size()) {
            min.offer(max.poll());
        }

    }
    
    public double findMedian() {
        if (max.size() != min.size()) {
            return (double)(min.peek() / 1.0);
        }

        return (double)((max.peek() + min.peek()) / 2.0);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */