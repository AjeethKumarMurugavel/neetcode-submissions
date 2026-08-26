class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> (b-a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if(maxHeap.size() - 1 > minHeap.size()) {
            int maxVal = maxHeap.poll();
            minHeap.offer(maxVal);
        } else if(minHeap.size() > maxHeap.size()){
            int val = minHeap.poll();
            maxHeap.offer(val);
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return ((double)(minHeap.peek() + maxHeap.peek()))/2.0;
        } else {
            return maxHeap.peek();
        }
        
    }
}
