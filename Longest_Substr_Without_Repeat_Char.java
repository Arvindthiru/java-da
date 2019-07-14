class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
        {
            return 0;
        }
        int i=0,pos=0,maxlen=0,curlen=0;
        char c;
        Set<Character> check = new HashSet<Character>();
        while(i<s.length())
        {
            c = s.charAt(i);
            if(check.isEmpty()==false)
            {
                if(check.contains(c) == false)
                {
                    check.add(c);
                    curlen++;
                    if(maxlen<curlen)
                    {
                        maxlen = curlen;
                    }
                    i++;
                }
                else
                {
                    i = pos+1;
                    check.clear();
                }
            }
            else
            {
                pos = i;
                check.add(c);
                curlen = 1;
                if(maxlen<curlen)
                {
                    maxlen = curlen;
                }
                i++;
            }    
        }
        return maxlen;
    }
}
