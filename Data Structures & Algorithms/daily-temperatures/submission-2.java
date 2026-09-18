class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            } 

            while(!stack.isEmpty()) {
                if(temperatures[stack.peek()] < temperatures[i]) {
                    int idx = stack.pop();
                    ans[idx] = i - idx;
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = 0;
        }

        return ans;
    }
}
