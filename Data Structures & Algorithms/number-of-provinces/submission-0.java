class Solution {

    public void dfs(int node, int[][] isConnected) {
        visited[node] = true;
        for(int i=0; i<isConnected[node].length; i++) {
            if(isConnected[node][i] == 1 && !visited[i]) {
                dfs(i, isConnected);
            }
        }
    }

    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        int numOfIslands = 0;
        for(int i=0; i<isConnected.length; i++) {
            if(!visited[i]) {
                numOfIslands++;
                dfs(i, isConnected);
            }
        }
        return numOfIslands;
    }
}