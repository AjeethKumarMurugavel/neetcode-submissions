class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;

        for(int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while(minSpeed <= maxSpeed) {
            int speed = minSpeed + (maxSpeed - minSpeed)/2;
            if(canFinish(piles, speed, h)) {
                maxSpeed = speed - 1;
            } else {
                minSpeed = speed + 1;
            }
        }
        return minSpeed;
    }

    public boolean canFinish(int[] piles, int speed, int hours) {
        int timeTaken = 0;
        for(int pile : piles) {
            timeTaken += (int)Math.ceil((double) pile/speed);
            if(timeTaken > hours) {
                return false;
            }
        }
        return true;
    }
}
