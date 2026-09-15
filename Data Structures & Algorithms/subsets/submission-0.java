class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, result, current);
        return result;
    }

    public void backtrack(int[] nums, int idx, List<List<Integer>> result, List<Integer> current) {
        if(idx > nums.length) {
            return;
        }
        result.add(new ArrayList<>(current));

        for(int i=idx; i < nums.length; i++) {
            if(i != idx && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i+1, result, current);
            current.remove(current.size() -1);
        }
    }
}
