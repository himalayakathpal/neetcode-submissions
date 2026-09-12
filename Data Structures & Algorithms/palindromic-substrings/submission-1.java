class Solution {
    private int expandSubstring(int l, int r, String s) {
        int count = 0;
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0;i<s.length();i++) {
            count+= expandSubstring(i,i,s);
            count+= expandSubstring(i,i+1,s);
        }
        return count;
    }
}
