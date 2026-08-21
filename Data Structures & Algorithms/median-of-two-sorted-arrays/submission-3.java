class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int half = (len1+len2+1)/2;

        int minToTake = Math.max(0, half - len2);
        int maxToTake = Math.min(len1, half);

        while(minToTake <= maxToTake) {
            int cut1 = (minToTake + maxToTake)/2;
            int cut2 = half - cut1;

            int maxLeft1 = cut1 >0 ? nums1[cut1-1] : Integer.MIN_VALUE;
            int maxLeft2 = cut2 > 0 ? nums2[cut2-1] : Integer.MIN_VALUE;
            int minRight1 = cut1 < len1 ? nums1[cut1] : Integer.MAX_VALUE;
            int minRight2 = cut2 < len2 ? nums2[cut2] : Integer.MAX_VALUE;

            if(maxLeft1 > minRight2) {
                maxToTake = cut1 - 1;
            } else if(maxLeft2 > minRight1) {
                minToTake = cut1 + 1;
            } else {
                int minRight = Math.min(minRight1, minRight2);
                int maxLeft = Math.max(maxLeft1, maxLeft2);

                if((len1 + len2)%2 == 1) {
                    return maxLeft;
                } else {
                    return (maxLeft + minRight)/2.0;
                }
            }
        }

        return 0.00;
    }
}
