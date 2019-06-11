class Solution {
    public int strStr(String haystack, String needle) {
        char[] h_arr = haystack.toCharArray();
        char[] n_arr = needle.toCharArray();
        int i=0,j=0,n_len,found_needle=0,pos =-1;
        n_len = needle.length();
        if(needle.length() > haystack.length())
        {
            return -1;
        }
        if(needle.length() == 0 && haystack.length() == 0)
        {
            return 0;
        }
        if(needle.length() == 0)
        {
            return 0;
        }
        while(i<haystack.length() && j<needle.length())
        {
            if(h_arr[i] == n_arr[j])
            {
                if(found_needle == 0)
                {
                    found_needle = 1;
                    pos = i;
                }
                i++;
                j++;
                n_len--;
                
            }
            else
            {
                if(found_needle == 1)
                {
                    n_len = needle.length();
                    found_needle = 0 ;
                    i = pos+1;
                    pos =- 1;
                    j = 0;
                    continue;  
                }
                i++;
            }
        }
        if(pos >= 0 && n_len == 0)
        {
            return pos;
        }
        return -1;
        }
        
    }
