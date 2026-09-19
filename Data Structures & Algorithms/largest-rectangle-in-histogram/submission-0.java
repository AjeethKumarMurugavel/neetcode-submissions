class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        int maxRect = 0;
        for(int i=0; i<n; i++) {
            if(stack.isEmpty() || stack.peek()[1] <= heights[i]) {
                stack.push(new int[] {i, heights[i]});
                continue;
            }
            int ind = i;
            while(!stack.isEmpty()) {
                if(stack.peek()[1] > heights[i]) {
                    int[] idx = stack.pop();
                    ind = idx[0];
                    maxArea = Math.max(maxArea, idx[1]*(i-idx[0]));
                } else {
                    break;
                }
            }
            stack.push(new int[] {ind, heights[i]});
        }

        while(!stack.isEmpty()) {
            int[] idx = stack.pop();
            maxArea = Math.max(maxArea, idx[1]*(n-idx[0]));
        }
        return maxArea;
    }
}