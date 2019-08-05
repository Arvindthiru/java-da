class Solution {
    
    public void sortByValue(Map<Integer,Integer> map)
    {
        List<Map.Entry<Integer,Integer>> sortedmap = new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
        
        Collections.sort(sortedmap,new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Collections.reverse(sortedmap);
        map.clear();
        for(Map.Entry<Integer,Integer> elem : sortedmap)
        {
            map.put(elem.getKey(),elem.getValue());
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        int count = 0,i;
        Map<Integer,Integer> freq = new LinkedHashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num:nums)
        {
            if(freq.containsKey(num) == false)
            {
                freq.put(num,1);
            }
            else
            {
                freq.put(num,freq.get(num)+1);
            }
        }
        sortByValue(freq);
        for(Map.Entry<Integer,Integer> elem : freq.entrySet())
        {
            count++;
            if(count>k)
            {
                break;
            }
            result.add(elem.getKey());
        }
        
        return result;
    }
}
