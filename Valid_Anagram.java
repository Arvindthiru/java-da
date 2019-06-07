class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() ==0 && t.length() == 0)
        {
            return true;
        }
        if(s.length() != t.length())
        {
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int i;
        for(i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else
            {
                map.put(s.charAt(i),1);
            }
        }
        for(i=0;i<t.length();i++)
        {
            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>0)
            {
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
            else
            {
                return false;
            }
        }
        return true;
        
    }
}
