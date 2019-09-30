class MedianFinder {
    PriorityQueue<Double> min;
    PriorityQueue<Double> max;
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        double temp;
        max.add((double)num);
        temp = max.poll();
        min.add(temp);
        if(max.size()<min.size())
        {
            temp = min.poll();
            max.add((double)temp);
        }
    }
    
    public double findMedian() {
        if(max.size()-min.size() == 1)
        {
            return max.peek();
        }
        else
        {
            return (min.peek()+max.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
