class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int value: hand) {
            mp.put(value, mp.getOrDefault(value,0)+1);
        }

        while (!mp.isEmpty()) {
            Map.Entry<Integer, Integer> entry = mp.firstEntry(); 
            int smallestElement = entry.getKey();
            int i = 0;
            while (i<groupSize) {
                if (!mp.containsKey(smallestElement+i)) {
                    return false;
                }
                int prevValue = mp.get(smallestElement+i);
                if (prevValue == 1) mp.remove(smallestElement+i);
                else mp.put(smallestElement+i, prevValue-1);
                i++;
            }
        }
        return true;

    }
}
