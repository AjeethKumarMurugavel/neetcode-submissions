class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int best = 0;
        for(int num : nums) {
            if(hashMap.containsKey(num)) {
                continue;
            }
            int left = hashMap.getOrDefault(num-1, 0);
            int right = hashMap.getOrDefault(num+1, 0);
            int len = left + right + 1;
            hashMap.put(num, len);
            hashMap.put(num-left, len);
            hashMap.put(num+right, len);
            best = Math.max(len, best);
        }

        return best;
    }
}
