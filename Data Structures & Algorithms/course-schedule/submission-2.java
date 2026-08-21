class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] preReq : prerequisites) {
            int a = preReq[0];
            int b = preReq[1];
            adjList.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }

        for(int i=0; i < numCourses; i++){
            if(!dfs(i, visited, adjList)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, Set<Integer> visited, HashMap<Integer, List<Integer>> adjMap) {
        if(visited.contains(node)){
            return false;
        }
        if(!adjMap.containsKey(node)){
            return true;
        }

        visited.add(node);
        for(int preReq : adjMap.get(node)){
            if(!dfs(preReq, visited, adjMap)){
                return false;
            }
        }
        visited.remove(node);
        adjMap.remove(node);
        return true;
    }
}
