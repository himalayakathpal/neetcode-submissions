class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (int i=0;i<strs.size();i++) {
            int charCount = strs.get(i).length();
            encodedString.append(charCount).append('#').append(strs.get(i));
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> strs = new ArrayList<>();
        while (i<str.length()) {
            int j = i;
            while(str.charAt(j)!='#') {
                j++;
            }
            int count = Integer.parseInt(str.substring(i, j));
            String temp = count>0?str.substring(j+1,j+count+1):"";
            strs.add(temp);
            i = j+1+count;
        }
        return strs;

    }
}
