class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            mp.computeIfAbsent(temp, k -> new ArrayList<>()).add(strs[i]);
        }

        for (List<String> list : mp.values()) {
            result.add(list);
        }
        return result;
    }
}
