class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        int uniqueCharCount = 0;
        for (int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            int prevCount = tMap.getOrDefault(c,0);
            if (prevCount == 0) uniqueCharCount++;
            tMap.put(c, prevCount+1);
        }

        Map<Character, Integer> sMap = new HashMap<>();

        int i = 0, j=0;
        int done = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        while (i<=j && j<s.length()) {
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j),0)+1);
            if (tMap.containsKey(s.charAt(j)) && sMap.get(s.charAt(j)).equals(tMap.get(s.charAt(j)))) done++;
            if (done == uniqueCharCount) {
                while (done == uniqueCharCount) {
                    if (j-i+1 < minLength) {
                        minLength = j-i+1;
                        minStart = i;
                    }
                    sMap.put(s.charAt(i), sMap.get(s.charAt(i))-1);
                    if (tMap.containsKey(s.charAt(i)) && sMap.get(s.charAt(i)) < tMap.get(s.charAt(i))) done--;
                    i++; 
                }
            }
                j++;
        }

        return minLength == Integer.MAX_VALUE? "" : s.substring(minStart, minStart+minLength);

    }
}
