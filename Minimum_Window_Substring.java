class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0 || s.length() == 0)
        {
            return "";
        }
        int i,left=0,right=0,formed=0,required,size;
        char c,d;
        Map<Character,Integer> tmap = fillMap(t);
        Map<Character,Integer> smap = new HashMap<>();
        required = tmap.size();
        size = Integer.MAX_VALUE;
        int fleft=0,fright=0;
        while(right<s.length())
        {
            c = s.charAt(right);
            if(tmap.containsKey(c)==true)
            {
                if(smap.containsKey(c) == false)
                {
                    smap.put(c,1);
                }
                else
                {
                    smap.put(c,smap.get(c)+1);
                }
                if(smap.get(c).equals(tmap.get(c)))
                {
                    formed = formed+1;
                }
            }
            if(formed == required)
            {
                while(left<=right && formed == required)
                {
                    if(right-left+1<size)
                    {
                        size = right-left+1;
                        fleft = left;
                        fright = right;
                    }
                    d = s.charAt(left);
                    if(tmap.containsKey(d) == true)
                    {
                        smap.put(d,smap.get(d)-1);
                        if(tmap.get(d) > smap.get(d))
                        {
                            formed--;
                        }
                    }
                    left++;
                }
            }
            right++; 
        }
        if(size == Integer.MAX_VALUE)
        {
            return "";
        }
        return s.substring(fleft,fright+1);   
    }
    
    public Map<Character,Integer> fillMap(String str)
    {
        int i;
        Map<Character,Integer> map = new HashMap<>();
        for(i=0;i<str.length();i++)
        {
            if(map.containsKey(str.charAt(i))==false)
            {
                map.put(str.charAt(i),1);
            }
            else
            {
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
        }
        return map;
    }
}
