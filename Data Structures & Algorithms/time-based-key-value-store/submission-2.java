class TimeMap {

    class Pair {
        int key;
        String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<String, List<Pair>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> keyValues = timeMap.computeIfAbsent(key, k -> new ArrayList<Pair>());
        keyValues.add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> keyValues = timeMap.get(key);
        String result = "";
        if(keyValues != null) {
            int right = keyValues.size() - 1;
            int left = 0;
            while(left <= right) {
                int mid = left + (right - left)/2;
                Pair midPair = keyValues.get(mid);
                if(midPair.key <= timestamp) {
                    result = midPair.value;
                    left = mid+1;
                } else {
                    right = mid -1;
                }

            }
        }
        return result;
    }
}
