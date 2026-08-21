class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int num : matchsticks) {
            sum += num;
        }
        if(sum%4 != 0) {
            return false;
        }
        int target = sum/4;
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
        }
        if (matchsticks[0] > target) {
            return false;
        }
        int[] sides = new int[4];
        return bfs(matchsticks, 0, sides, target);
    }

    public boolean bfs(int[] matchsticks, int index, int[] sides, int target) {
        if(index == matchsticks.length){
            return (sides[0] == sides[1]) && (sides[1] == sides[2]);
        }

        for(int i=0; i<4; i++) {
            if(sides[i] + matchsticks[index] <= target) {
                sides[i] += matchsticks[index];
                if(bfs(matchsticks, index+1, sides, target)) {
                    return true;
                }
                sides[i] -= matchsticks[index];
                if(sides[i] == 0) {
                    break;
                }
            }
        }
        return false;
    }
}