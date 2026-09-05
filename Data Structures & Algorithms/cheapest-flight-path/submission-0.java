class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for(int i=0; i<=k; i++) {
            int[] newCost = cost.clone();
            for(int[] flight : flights) {
                int source = flight[0];
                int dest = flight[1];
                int price = flight[2];

                if(cost[source] == Integer.MAX_VALUE) {
                    continue;
                }
                int candidateCost = cost[source] + price;

                if(candidateCost < newCost[dest]) {
                    newCost[dest] = candidateCost;
                }
            }
            cost = newCost;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
