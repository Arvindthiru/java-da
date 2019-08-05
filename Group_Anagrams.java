//Solution 1 using sorting

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

// Solution 2 using generated hash values for strings

class Solution {
    public int getKey(String value)
    {
        int i,c;
        int sum=0;
        for(i=0;i<value.length();i++)
        {
            c = value.charAt(i);
            sum = sum+(int)Math.pow(c,4);
        }
        return sum;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int i;
        int key;
        List<String> anagramList;
        List<List<String>> result = new ArrayList<>();
        Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
        for(i=0;i<strs.length;i++)
        {
            key = getKey(strs[i]);
            //System.out.println(key);
            if(map.containsKey(key) == false)
            {
                anagramList = new ArrayList<String>();
                anagramList.add(strs[i]);
                map.put(key,anagramList);
            }
            else
            {
                anagramList = map.get(key);
                anagramList.add(strs[i]);
                map.put(key,anagramList);
            }
            //System.out.println(map);
        }
        for(Map.Entry<Integer,List<String>> entry : map.entrySet())
        {
            result.add(entry.getValue());
        }
        return result;
    }
}
