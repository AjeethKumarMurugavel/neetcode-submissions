class Solution {
    List<List<Integer>> result;
    List<Integer> current; 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        current = new ArrayList<>();
        backTrack(nums, 0);
        return result;
    }

    public void backTrack(int[] nums, int idx) {
        if(idx > nums.length){
            return;
        }
        result.add(new ArrayList<>(current));

        for(int i=idx; i < nums.length; i++) {
            if(i != idx && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            backTrack(nums, i+1);
            current.remove(current.size() -1);
        }
    }
}
