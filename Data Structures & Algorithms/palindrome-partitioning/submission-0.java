class Solution {
    private boolean isPalindrome(String s) {
        int end= s.length()-1;
        int start = 0;
        while (start<=end) {
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    private void partitionHelper(String s, int index, List<String> possibleList, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(possibleList));
            return;
        }
        for (int i=index;i<s.length();i++) {
            String temp = s.substring(index,i+1);
            if (isPalindrome(temp)) {
                possibleList.add(temp);
                partitionHelper(s,i+1,possibleList,result);
                possibleList.remove(possibleList.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partitionHelper(s,0,temp,result);
        return result;
    }
}
