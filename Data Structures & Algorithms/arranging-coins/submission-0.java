class Solution {
    public int arrangeCoins(int n) {
        int k =0;
        while(n >= 0) {
            k++;
            n = n - k;
        }
        if(n < 0) {
            return k-1;
        } else {
            return k;
        }

        
    }
}