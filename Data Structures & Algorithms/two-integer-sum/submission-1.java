class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexmap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(indexmap.containsKey(nums[i])) {
                return new int[]{indexmap.get(nums[i]), i};
            }
            indexmap.put(target-nums[i], i);
        }
        return new int[0];
    }
}
