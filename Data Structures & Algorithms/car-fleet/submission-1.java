class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] posVsSpeed = new int[n][2];
        for(int i=0; i < n; i++) {
            posVsSpeed[i][0] = position[i];
            posVsSpeed[i][1] = speed[i];
        }

        Arrays.sort(posVsSpeed, (a,b) -> Integer.compare(a[0], b[0]));

        Stack<Double> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            double estTime = ((double)target - posVsSpeed[i][0])/posVsSpeed[i][1];
            if(stack.isEmpty() || stack.peek() < estTime) {
                stack.push(estTime);
            }
        }
        return stack.size();
    }
}
