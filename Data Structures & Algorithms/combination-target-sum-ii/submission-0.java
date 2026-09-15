class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return result;
    }

    public void backtrack(int[] nums, int idx, int target) {
        if(target < 0 || idx > nums.length) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(current));
        }

        for(int i=idx; i<nums.length; i++) {
            if(i != idx && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i+1, target-nums[i]);
            current.remove(current.size()-1);
        }
    }
}