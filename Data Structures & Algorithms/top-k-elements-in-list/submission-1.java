class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }

        Map<Integer, List<Integer>> mp1 = new HashMap<>();
        
        for (Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            List<Integer> presentList = mp1.getOrDefault(entry.getValue(), new ArrayList<>());
            presentList.add(entry.getKey());
            mp1.put(entry.getValue(), presentList);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i=nums.length;i>0;i--) {
            List<Integer> elementsList = mp1.getOrDefault(i, new ArrayList<>());
            for (int j: elementsList) {
                result[index++] = j;
                if (index == k) return result;
            }
        }

        return result;
    }
}
