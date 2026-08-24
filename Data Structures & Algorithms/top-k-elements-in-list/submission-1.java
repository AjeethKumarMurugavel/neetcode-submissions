class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> (freqMap.get(a)-freqMap.get(b)));
        for(int num : freqMap.keySet()) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];

        int i=0;
        while(!queue.isEmpty()) {
            result[i++] = queue.poll();
        }

        return result;
    }
}
