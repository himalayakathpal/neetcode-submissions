class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0,maxCount=0;
        int stringLength = s.length();
        Map<Character,Integer> mp = new HashMap<>();
        int i = 0,j=0;
        while (i<stringLength && j<stringLength) {
            int presentCount = mp.getOrDefault(s.charAt(j) , 0);
            mp.put(s.charAt(j), presentCount+1);
            maxCount = Math.max(maxCount,presentCount+1);
            int currLength = j-i+1;
            if (currLength - maxCount <= k) {
                maxLength = Math.max(maxLength, currLength);
            }
            else {
                while (i<=j && currLength - maxCount>k) {
                    mp.put(s.charAt(i), mp.get(s.charAt(i))-1);
                    i++;
                    currLength = j-i+1;
                }
                maxLength = Math.max(maxLength, currLength);
            }
            j++;

        }

        return maxLength;
    }
}
