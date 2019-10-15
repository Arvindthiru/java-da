class Solution {
    public List<String> restoreIpAddresses(String s) {
        int index=0;
        int split = 0;
        String r = new String();
        List<String> result = new ArrayList<>();
        generateIpAddresses(s,r,index,result,split);
        return result;
    }
    
    public void generateIpAddresses(String s,String r,int index, List<String> result, int split)
    {
        if(split == 4)
        {
            return;
        }

        for(int i=index;i<index+3;i++)
        {
            if(i>s.length()-1)
            {
                break;
            }
            r = r+s.charAt(i);
            String check = r.substring(index+split,i+split+1);
            if(check.length() == 3)
            {
                if(Integer.parseInt(check) < 100)
                {
                    return;
                }
            }
            if(check.length() == 2)
            {
                if(Integer.parseInt(check) <10)
                {
                    return;
                }
            }
            int steps = i-index;
            if(Integer.parseInt(check)>=0 && Integer.parseInt(check)<=255)
            {
                if(r.length() == s.length()+3 && split == 3)
                {
                    result.add(r);
                }
                generateIpAddresses(s,r+'.',index+steps+1,result,split+1);
            }
            else
            {
                return;
            }
        }
    }
}
