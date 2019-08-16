class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0)
        {
            return 0;
        }
        if(tokens.length == 1)
        {
            return Integer.parseInt(tokens[0]);
        }
        int i,elem,e1,e2;
        String str;
        Stack<Integer> elems = new Stack<>();
        for(i=0;i<tokens.length;i++)
        {
            str = tokens[i];
            if(str.compareTo("+") == 0 || str.compareTo("-")  == 0|| str.compareTo("*") == 0|| str.compareTo("/") == 0)
            {
                e2 = elems.pop();
                e1 = elems.pop();
                if(str.compareTo("+") == 0)
                {
                    elems.push(e1+e2);
                }
                else if(str.compareTo("-") == 0)
                {
                    elems.push(e1-e2);
                }
                else if(str.compareTo("*") == 0)
                {
                    elems.push(e1*e2);
                }
                else if(str.compareTo("/") == 0)
                {
                    elems.push(e1/e2);
                }
            }
            else
            {
                elem = Integer.parseInt(str);
                elems.push(elem);
            }
        }
        return elems.pop();
    }
}
