class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i;
        if(strs.length == 0)
        {
            return "";
        }
        String lcs = strs[0]; 
        for(i=1;i<strs.length;i++)
        {
            lcs = commonPrefix(strs[i],lcs); 
        }
        return lcs;
        
    }
    public String commonPrefix(String s1,String s2)
    {
        int i=0;
        StringBuilder s = new StringBuilder();
        while(i<s1.length() && i<s2.length())
        {
            if(s1.charAt(i) == s2.charAt(i))
            {
                s.append(s1.charAt(i));
            }
            else
            {
                break;
            }
            i++;
        }
        return s.toString();
    }
}
