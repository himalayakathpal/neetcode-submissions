class Solution {
    public boolean checkSame (int[] count1, int[] count2) {
        for (int i=0;i<26;i++) {
            if (count1[i]!=count2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1CharCount = new int[26];
        for (int i = 0;i<s1.length();i++) {
            s1CharCount[s1.charAt(i)-'a']++;
        }

        int i = 0;
        int j = 0;
        int[] subCharCount = new int[26];
        while (j<s1.length()) {
            subCharCount[s2.charAt(j)-'a']++;
            j++;
        }
        if (checkSame(s1CharCount, subCharCount)) return true;
        subCharCount[s2.charAt(i)-'a']--;
        i++;
        while (j<s2.length()) {
            subCharCount[s2.charAt(j)-'a']++;
            if (checkSame(s1CharCount, subCharCount)) return true;
            j++;
            subCharCount[s2.charAt(i)-'a']--;            
            i++;
        }

        return false;
    }
}
