class Solution {
    public int maxArea(int[] heights) {
        if(heights.length <= 1){
            return 0;
        }
        int left = 0;
        int right = heights.length-1;

        int maxArea = 0;
        while(left < right) {
            int breadth = right - left;
            int height = Math.min(heights[right], heights[left]);
            maxArea = Math.max(maxArea, breadth*height);
            if(heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}
