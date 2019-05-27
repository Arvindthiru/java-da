    public void moveZeroes(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int i,j=0,pos,size;
        size = nums.length;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                map.put(j,nums[i]);
                j = j+1;
            }
            
        }
        for(HashMap.Entry<Integer,Integer> itr : map.entrySet())
        {
            pos = itr.getKey();
            nums[pos] = itr.getValue();
        }
        while(j<size)
        {
            nums[j] = 0;
            j = j+1;
        }
    }
}
