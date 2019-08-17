class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder s = new StringBuilder();
        generateCombinations(result,0,0,s,n);
        return result;   
    }
    
    void generateCombinations(List<String> result,int open, int close, StringBuilder s, int n)
    {
        if(s.length() == 2*n)
        {
            result.add(s.toString());
            return;
        }
        if(open<n)
        {
            generateCombinations(result,open+1,close,s.append("("),n);
            s.deleteCharAt(s.length()-1);
        }
        if(close<open)
        {
            generateCombinations(result,open,close+1,s.append(")"),n);
            s.deleteCharAt(s.length()-1);
        }
    }
}
