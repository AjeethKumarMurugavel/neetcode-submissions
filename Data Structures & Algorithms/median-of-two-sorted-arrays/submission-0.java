class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int half = (m+n+1)/2;
        int lo = Math.max(0, half - n);  // ✓ clamp lo
        int hi = Math.min(m, half);      // ✓ clamp hi

        while(lo <= hi){
            int cut1 = (lo+hi)/2;
            int cut2 = half - cut1;

            int maxLeft1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int minRight1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
            int maxLeft2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int minRight2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];

            if(maxLeft1 > minRight2){
                hi = cut1 - 1;
            } else if(maxLeft2 > minRight1){
                lo = cut1+1;
            } else {
                int leftMax = Math.max(maxLeft1, maxLeft2);
                int minRight = Math.min(minRight1, minRight2);

                if((m+n)%2 == 1){
                    return leftMax;
                } else {
                    return (leftMax + minRight)/2.0;
                }
            }
        }
        return 0.00;
    }
}