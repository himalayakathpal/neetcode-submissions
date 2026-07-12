class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>> freq = new ArrayList<>();
        for (int i=0;i<=nums.length;i++) {
            freq.add(new ArrayList<>());
        }
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()) {
            int freqCount = entry.getValue();
            int num = entry.getKey();
            freq.get(freqCount).add(num);
        }
        int[] result = new int[k];
        int m = 0;
        for (int i=nums.length;i>0;i--) {
            int j=0;
            while(j<freq.get(i).size() &&m<k) {
                result[m] = freq.get(i).get(j);
                j++;
                m++;
            }
        }
        return result;
    }
}
