class Solution {
    private void generateHelper(String digits, int index, StringBuilder sb, List<String> result,Map<Character, String> mp) {
        if (index == digits.length()) {
            result.add(new String(sb));
            return;
        }
        char c = digits.charAt(index);
        String values = mp.get(c);
        for (int i=0;i<values.length();i++) {
            sb.append(values.charAt(i));
            generateHelper(digits,index+1,sb,result,mp);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0) return result;
        StringBuilder sb = new StringBuilder();
        Map<Character, String> mp = new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        generateHelper(digits,0,sb,result,mp);
        return result;
    }
}
