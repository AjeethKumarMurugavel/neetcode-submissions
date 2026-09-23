class Solution {

    public void dfs(int node, int[][] isConnected) {
        visited[node] = true;
        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[node][i] == 1 && !visited[i]) {
                dfs(i, isConnected);
            }
        }
    }

    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        int provinces = 0;
        for(int i=0; i < isConnected.length; i++) {
            if(!visited[i]) {
                provinces++;
                dfs(i, isConnected);
            }
        }
        return provinces;
    }
}