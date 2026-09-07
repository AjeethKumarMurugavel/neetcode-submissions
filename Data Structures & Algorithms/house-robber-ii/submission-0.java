class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(1, nums.length, nums), robHelper(0, nums.length-1, nums));
    }

    public int robHelper(int start, int end, int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for(int i=start; i<end; i++) {
            int maxRob = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = maxRob;
        }
        return rob2;
    }
}