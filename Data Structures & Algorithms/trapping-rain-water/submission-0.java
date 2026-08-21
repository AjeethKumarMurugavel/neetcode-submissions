class Solution {
    public int trap(int[] height) {
        if(height.length <=2){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int waterToHold = 0;
        while(left < right) {
            if(height[left] > height[right]){
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterToHold = waterToHold + rightMax - height[right];
            } else {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterToHold = waterToHold + leftMax - height[left];
            }
        }
        return waterToHold;
    }
}
