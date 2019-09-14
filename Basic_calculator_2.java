class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i=0,num,num1,result;
        char c,sign;
        sign = '+';
        result = 0;
        while(i<s.length())
        {
            if(s.charAt(i)==' ')
            {
                i++;
                continue;
            }
            if(Character.isDigit(s.charAt(i))==true)
            {
                num = s.charAt(i)-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1)))
                {
                    i++;
                    num = num*10+(s.charAt(i)-'0'); 
                }
                if(sign == '+')
                {
                    stack.push(num);
                    i++;
                }
                if(sign == '-')
                {
                    stack.push(-1*num);
                    i++;
                }
                if(sign == '*')
                {
                    num1 = stack.pop();
                    stack.push(num1*num);
                    i++;
                }
                if(sign == '/')
                {
                    num1 = stack.pop();
                    stack.push(num1/num);
                    i++;
                }
            }
            else
            {
                sign = s.charAt(i);
                i++;
            }
        }
        while(stack.isEmpty()==false)
        {
            result = result+stack.pop();
        }
        return result;
    }
}
