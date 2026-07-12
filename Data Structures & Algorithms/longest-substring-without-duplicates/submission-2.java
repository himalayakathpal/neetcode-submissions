class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int longestSubstr = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while(j<n) {
            if (mp.containsKey(s.charAt(j)) && mp.get(s.charAt(j))>=i) {
                longestSubstr = Math.max(longestSubstr, j - i);
                i = mp.get(s.charAt(j)) +1;
            } 
            mp.put(s.charAt(j) , j);
            j++;
        }
        longestSubstr = Math.max(longestSubstr, j - i);
        return longestSubstr;
    }
}
