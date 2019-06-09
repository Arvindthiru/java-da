class Solution {
    public int myAtoi(String str) {
        int i,sign=1,startno=0,power;
        long sum = 0;
        char[] c_arr = str.toCharArray();
        ArrayList<Integer> chars = new ArrayList<Integer>();
        for(i=0;i<str.length();i++)
        {
            if(c_arr[i] ==' ')
            {
                if(startno == 0)
                {
                    continue;
                }
                else
                {
                    break;
                }   
            }
            if(c_arr[i] == '-')
            {
                
                if(startno == 0)
                {
                    sign = -1;
                    startno = 1;
                }
                else if(startno ==1)
                {
                    break;
                }
                continue;
            }
            if(c_arr[i] == '+')
            {
                
                if(startno == 0)
                {
                    sign = +1;
                    startno = 1;
                }
                else if(startno == 1)
                {
                    break;
                }
                continue;
            }
            if(c_arr[i]>=48 && c_arr[i]<=57)
            {
                startno=1;
                chars.add((int)c_arr[i] - 48); 
            }
            else
            {
                if(startno == 0)
                {
                    return 0;
                }
                if(startno == 1)
                {
                    break;
                }
            }
        }
        System.out.println(chars);
        if(chars.size() == 0)
        {
            return 0;
        }
        power = chars.size()-1;
        for(i=0;i<chars.size();i++)
        {
            sum = sum + (long)chars.get(i)*(int)Math.pow(10,power);
            power--;
        }
        if(sign == -1)
        {
            sum = sum*-1;
        }
        if(sum > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        if(sum < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
        
        return (int)sum;
    }
}
