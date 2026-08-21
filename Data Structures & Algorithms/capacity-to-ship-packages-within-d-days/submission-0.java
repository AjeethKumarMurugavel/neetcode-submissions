class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxCap = 0;
        int minCap = 1;

        for(int weight : weights) {
            maxCap += weight;
            minCap = Math.max(weight, minCap);
        }

        int minCapNeeded = maxCap;
        
        while(minCap <= maxCap) {
            int mid = minCap + (maxCap - minCap)/2;
            if(canFinish(weights, mid, days)) {
                maxCap = mid-1;
                minCapNeeded = Math.min(mid, minCapNeeded);
            } else {
                minCap = mid+1;
            }
        }
        return minCapNeeded;
    }

    public boolean canFinish(int[] weights, int capacity, int days) {
        int load = 0;
        int daysTaken = 0;
        for(int weight : weights) {
            load+=weight;
            if(load == capacity) {
                daysTaken++;
                load = 0;
            } else if(load > capacity) {
                daysTaken++;
                load = weight;
            }
            if(daysTaken > days) {
                System.out.println("False for " + capacity);
                return false;
            }
        }
        if(load > 0) {
            daysTaken++;
        }
        return daysTaken <= days;
    }
}