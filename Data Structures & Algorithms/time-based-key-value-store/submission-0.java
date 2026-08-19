class Pair {
    String value;
    int timestamp;
    Pair (String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    Map<String, List<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!mp.containsKey(key)) return "";
        List<Pair> pairsList = mp.get(key);

        String mostRecentValue = "";

        int start = 0;
        int end = pairsList.size()-1;

        while (start<=end) {
            int mid = (start+end)/2;
            if (pairsList.get(mid).timestamp == timestamp) {
                return pairsList.get(mid).value;
            }
            if (pairsList.get(mid).timestamp > timestamp) {
                end = mid-1;
            } else {
                start = mid+1;
                mostRecentValue = pairsList.get(mid).value;
            }
        }

        return mostRecentValue;

    }
}
