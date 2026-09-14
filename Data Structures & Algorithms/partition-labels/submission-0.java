class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i =0;i<s.length();i++) {
            mp.put(s.charAt(i), i);
        }

        int start =0;
        int end = 0;

        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i<s.length()) {
            end = Math.max(end, mp.get(s.charAt(i)));
            if (i == end) {
                result.add(end-start+1);
                start = i+1;
                end = i+1;
            }
            i++;
        }
        return result;
    }
}
