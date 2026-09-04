class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delay = new int[n];

        PriorityQueue<Integer> nodes = new PriorityQueue<>((a,b) ->(delay[a-1] - delay[b-1]));

        Arrays.fill(delay, Integer.MAX_VALUE);
        delay[k-1] = 0;
        nodes.offer(k);

        List<int[]>[] adjList = new List[n];

        for(int i=0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] time : times) {
            adjList[time[0]-1].add(new int[] {time[1], time[2]});
        }

        while(!nodes.isEmpty()) {
            int node = nodes.poll();
            List<int[]> edges = adjList[node-1];
            if(edges == null) {
                continue;
            }
            adjList[node-1] = null;
            System.out.println(node);
            for(int[] edge : edges) {
                int child = edge[0];
                int d = delay[node-1] + edge[1];
                if(d < delay[child-1]) {
                    delay[child-1] = d;
                    nodes.offer(child);
                }

            }
        }

        int maxDelay = 0;
        for(int i=0; i<n; i++) {
            maxDelay = Math.max(maxDelay, delay[i]);
        }

        return maxDelay == Integer.MAX_VALUE ? -1 : maxDelay;
    }
}
