class Solution {
    public String longestPalindrome(String s) {
        int i;
        StringBuilder str = new StringBuilder(s);
        String evenPal,oddPal,resultPal="";
        for(i=0;i<str.length();i++)
        {
            evenPal = checkPalindrome(str,i,i+1,1);
            oddPal = checkPalindrome(str,i,i,2);
            if(resultPal.length() < evenPal.length() || resultPal.length() < oddPal.length())
            {
                if(evenPal.length() > oddPal.length())
                {
                    resultPal = evenPal;
                }
                else
                {
                    resultPal = oddPal;
                }
            } 
        }
        return resultPal;
    }
    
    public String checkPalindrome(StringBuilder s, int j, int k,int type)
    {
        while(j>=0 && k<s.length())
        {
            if(s.charAt(j) == s.charAt(k))
            {
                j--;
                k++;
            }
            else
            {
                if(k==j+1)
                {
                    return s.substring(j,k);
                }
                break;
            }
        }
        return s.substring(j+1,k);
    }
}
