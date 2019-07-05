class Solution {
    public boolean isValid(String s) {
        int i;
        if(s.length() == 0)
        {
            return true;
        }
        if(s.length() == 1)
        {
            return false;
        }
        Stack<Character> check = new Stack<Character>();
        check.push(s.charAt(0));
        for(i=1;i<s.length();i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                check.push(s.charAt(i));
                continue;
            }
            else if(check.isEmpty() == true)
            {
                return false;
            }
            if(s.charAt(i) == ')')
            {
                if(check.peek() == '(' )
                {
                    check.pop();
                }
                else
                {
                    return false;
                }
            }
            else if(s.charAt(i) == ']')
            {
                if(check.peek() == '[' )
                {
                    check.pop();
                }
                else
                {
                    return false;
                }
            }
            else if(s.charAt(i) == '}')
            {
                if(check.peek() == '{' )
                {
                    check.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        if(check.isEmpty() == false)
        {
            return false;
        }
        return true;
        
    }
}
