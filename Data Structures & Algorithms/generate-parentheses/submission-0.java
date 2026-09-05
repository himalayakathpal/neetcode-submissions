class Solution {
    private void generateHelper(int open, int close, StringBuilder sb, List<String> result, int n) {
        if (open == n && close == n) {
            result.add(new String(sb));
        }
        if (open<n) {
            sb.append('(');
            generateHelper(open+1,close,sb,result,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close<open) {
            sb.append(')');
            generateHelper(open,close+1,sb,result,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int close =0;
        generateHelper(open,close,sb,result,n);
        return result;
    }
}
