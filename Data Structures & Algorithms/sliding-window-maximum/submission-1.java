class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k) {
            return new int[0];
        }

        int lenOfArr = nums.length - k + 1;
        int [] maxArr = new int[lenOfArr];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<nums.length; i++) {
            while(!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if(i-k+1 >= 0) {
                maxArr[i-k+1] = nums[deque.peekFirst()];
            }
        }

        return maxArr;
    }
}
