class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> inter = new ArrayList<>();
        if(nums1.length <= nums2.length)
        {
            inter = find_intersection(nums1,nums2);
        }
        else
        {
            inter = find_intersection(nums2,nums1);
        }
        //System.out.println(inter.size());
        int[] result = new int[inter.size()];
        Iterator<Integer> itr = inter.iterator();
        int i = 0;
        while(itr.hasNext())
        {
            result[i] = itr.next();
            i = i+1;
        }
        return result;
    }
    public ArrayList<Integer> find_intersection(int[] s_arr,int[] l_arr)
    {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        //HashMap<Integer,Integer> map2 = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int i;
       // int[] intersec = 
        
        for(i=0;i<s_arr.length;i++)
        {
            if(map1.containsKey(s_arr[i]))
            {
                map1.put(s_arr[i],map1.get(s_arr[i])+1); 
            }
            else
            {
                map1.put(s_arr[i],1);
            }
          
        }
        for(i=0;i<l_arr.length;i++)
        {
            if(map1.containsKey(l_arr[i]) && map1.get(l_arr[i]) > 0)
            {
                map1.put(l_arr[i],map1.get(l_arr[i])-1);
                result.add(l_arr[i]);
            }
        }
        return result;    
    }
    
}
