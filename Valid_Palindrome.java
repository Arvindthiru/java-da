class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
        {
            return true;
        }
        s = s.toUpperCase();
        int i,count=0;
        char[] c_arr = s.toCharArray();
        Stack<Character> pal = new Stack<Character>();
        char a,b;
        for(i=0;i<s.length();i++)
        {
            if( (c_arr[i]>=65 && c_arr[i]<=90) || (c_arr[i]>=48 && c_arr[i]<=57) )
            {
                pal.push(c_arr[i]);
                count++;
            }
            else
            {
                continue;
            }

        }
        i = 0;
        while(pal.empty()==false)
        {   
            a = pal.get(i);
            b = pal.peek();
            if(a == b)
            {
                pal.pop();
                i++;;
            }
            else
            {
                return false;
            }
            if(i>=count/2)
            {
                break;
            }    
        }
        
        return true;       
    }
}
