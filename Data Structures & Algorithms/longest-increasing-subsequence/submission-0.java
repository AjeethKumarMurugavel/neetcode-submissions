class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] lis = new int[n];

        int maxSeq = 0;
        for(int i=0; i<n; i++) {
            lis[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    lis[i] = Math.max(1 + lis[j], lis[i]);
                }
            }
            maxSeq = Math.max(maxSeq, lis[i]);
        }
        return maxSeq;
    }
}
