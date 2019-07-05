class Solution {
    public int romanToInt(String s) {
        int i=0,sum = 0;
        while(i<s.length())
        {
            if(s.charAt(i) == 'I' && i!=s.length()-1)
            {
                if(s.charAt(i+1) == 'V')
                {
                    sum = sum + 4;
                    i = i+2;
                }
                else if(s.charAt(i+1) == 'X')
                {
                    sum = sum + 9;
                    i = i+2;
                }
                else
                {
                    sum = sum + 1;
                    i++;
                }
            }
            else if(s.charAt(i) == 'X' && i!=s.length()-1)
            {
                if(s.charAt(i+1) == 'L')
                {
                    sum = sum + 40;
                    i = i+2;
                }
                else if(s.charAt(i+1) == 'C')
                {
                    sum = sum + 90;
                    i = i+2;
                }
                else
                {
                    sum = sum + 10;
                    i++;
                }
            }
            else if(s.charAt(i) == 'C' && i!=s.length()-1)
            {
                if(s.charAt(i+1) == 'D')
                {
                    sum = sum + 400;
                    i = i+2;
                }
                else if(s.charAt(i+1) == 'M')
                {
                    sum = sum + 900;
                    i = i+2;
                }
                else
                {
                    sum = sum + 100;
                    i++;
                }
            }
            else if(s.charAt(i) == 'V')
            {
                sum = sum + 5;
                i++;
            }
            else if(s.charAt(i) == 'L')
            {
                sum = sum + 50;
                i++;
            }
            else if(s.charAt(i) == 'D')
            {
                sum = sum + 500;
                i++;
            }
            else if(s.charAt(i) == 'M')
            {
                sum = sum + 1000;
                i++;
            }
            else if(s.charAt(i) == 'I')
            {
                sum = sum + 1;
                i++;
            }
            else if(s.charAt(i) == 'X')
            {
                sum = sum + 10;
                i++;
            }
            else if(s.charAt(i) == 'C')
            {
                sum = sum + 100;
                i++;
            }
        }
        return sum;
        
    }
}
