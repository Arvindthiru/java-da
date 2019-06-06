class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i,pos;
        char c,k;
        if(s.length() == 0)
        {
            return -1;
        }
        for(i=0;i<s.length();i++)
        {
            c = s.charAt(i);
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)+1);
   
            }
            else
            {
                map.put(c,1);
            }
            
        }
        for(i=0;i<s.length();i++)
        {
            if(map.get(s.charAt(i)) == 1)
            {
                return i;
            }

        }
        return -1;
        
        
    }
}
