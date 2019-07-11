class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int i;
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs.length == 0)
        {
            return result;
        }
        List<String> group;
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(i=0;i<strs.length;i++)
        {
            char[] sorted_str = strs[i].toCharArray();
            Arrays.sort(sorted_str);
            String s_str = new String(sorted_str);
            if(map.containsKey(s_str))
            {
                map.get(s_str).add(strs[i]);
            }
            else
            {
                group = new ArrayList<String>();
                group.add(strs[i]);
                map.put(s_str,group);     
            }
        }
        for(Map.Entry<String,List<String>> entry: map.entrySet())
        {
            result.add(entry.getValue());
        }
        return result;
    }
}
