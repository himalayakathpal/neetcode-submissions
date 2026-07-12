class Solution {

    public String encode(List<String> strs) {
        String encodedString = new String();        
        for (int i=0;i<strs.size();i++) {
            encodedString += (char) (strs.get(i).length() + '0');
            encodedString += strs.get(i);
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        System.out.println(str);
        int i = 0;
        int count;
        int j;
        List<String> ans = new ArrayList<String>();

        while (i<str.length()) {
            count = str.charAt(i) - '0';
            j = i+count+1;
            System.out.println(i);
            ans.add(str.substring(i+1, j));
            i = j;
        }
        return ans;
    }
}
