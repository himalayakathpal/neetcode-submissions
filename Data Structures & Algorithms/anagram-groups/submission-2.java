class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            int[] count = new int[26];
            for (int j = 0;j<strs[i].length();j++) {
                count[strs[i].charAt(j)-'a']++;
            }
            String key = Arrays.toString(count);
            List<String> existingList = mp.getOrDefault(key, new ArrayList<>());
            existingList.add(strs[i]);
            mp.put(key, existingList);
        }
        for (List<String> v: mp.values()) {
            result.add(v);
        }
        return result;
    }
}
