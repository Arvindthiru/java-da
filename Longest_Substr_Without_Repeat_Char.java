class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i,j,maxCount=0,count=0;
        char c;
        Map<Character,Integer> indexMap = new HashMap<>();
        j = 0;
        for(i=0;i<s.length();i++)
        {
            c = s.charAt(i);
            if(indexMap.containsKey(s.charAt(i)) == false)
            {
                indexMap.put(c,i);
                count++;
            }
            else
            {
                if(j>indexMap.get(c))
                {
                    indexMap.put(c,i);
                    count++;
                }
                else
                {
                    count = count - (indexMap.get(c)+1-j);
                    j = indexMap.get(c)+1;
                    indexMap.put(c,i);
                    count++;
                }
            }
            maxCount = Math.max(count,maxCount);  
        }
        return maxCount;
    }
}
