class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> arrayValues = new HashSet<>();
        for(int num : nums) {
            if(arrayValues.contains(num)){
                return true;
            }
            arrayValues.add(num);
        }
        return false;
    }
}