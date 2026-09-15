class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtrack(nums);
        return result;
    }

    public void backtrack(int[] nums) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                backtrack(nums);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }
}