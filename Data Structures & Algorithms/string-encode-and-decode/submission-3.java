class Solution {

    public String encode(List<String> strs) {
        String encodedString = new String();
        for (int i=0;i<strs.size();i++) {
            char charCount = (char)('0' + strs.get(i).length());
            encodedString += charCount;
            encodedString += strs.get(i);
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> strs = new ArrayList<>();
        while (i<str.length()) {
            int count = str.charAt(i) - '0';
            String temp = count>0?str.substring(i+1,i+count+1):"";
            strs.add(temp);
            i+=count+1;
        }
        return strs;

    }
}
