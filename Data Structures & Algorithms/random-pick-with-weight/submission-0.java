class Solution {
    
    int[] prefix;
    public Solution(int[] w) {
        prefix = new int[w.length];

        prefix[0] = w[0];
        for(int i=1; i<w.length; i++) {
            prefix[i] = prefix[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int left = 0;
        int right = prefix.length-1;
        int target = (int)Math.floor(Math.random()*prefix[right]);

        while(left < right) {
            int mid = (left+right)/2;
            if(prefix[mid] > target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */