class Solution {
    List<List<Integer>> result;
    List<Integer> current;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        current = new ArrayList<>();
        backTrack(candidates, target, 0);
        return result;
    }

    public void backTrack(int[] nums, int target, int idx) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            current.add(nums[i]);
            backTrack(nums, target-nums[i], i);
            current.remove(current.size()-1);
        }
    }
}