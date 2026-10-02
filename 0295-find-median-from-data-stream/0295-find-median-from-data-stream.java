class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.offer(num);

        while (!min.isEmpty() && max.peek() > min.peek()) {
            int a = max.poll();
            int b = min.poll();

            max.offer(b);
            min.offer(a);
        }

        if (max.size() > min.size() + 1) {
            min.offer(max.poll());
        }

        if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() > min.size()) {
            return (max.peek()) / 1.0;
        }

        return (max.peek() + min.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */