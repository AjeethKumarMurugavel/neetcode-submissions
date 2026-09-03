class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inOrder = new int[numCourses];

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        for(int[] preReq : prerequisites) {
            adjMap.computeIfAbsent(preReq[1], k -> new ArrayList<>()).add(preReq[0]);
            inOrder[preReq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int course = 0; course < numCourses; course++) {
            if(inOrder[course] == 0) {
                queue.offer(course);
            }
        }

        int[] courseOrder = new int[numCourses];
        int courseTaken = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            if(adjMap.containsKey(course)) {
                for(int child : adjMap.get(course)) {
                    inOrder[child]--;
                    if(inOrder[child] == 0) {
                        queue.offer(child);
                    }
                }
            }
            courseOrder[courseTaken++] = course;
        }
        return courseTaken == numCourses ? courseOrder : new int[0];
    }
}
