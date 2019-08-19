class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 0)
        {
            result.add(getRange((long)lower-1,(long)upper+1));
            return result;
        }
        int i;
        String temp;
        // Lower and first element
        temp = getLowerRange((long)lower,nums[0]);
        if(temp!="")
        {
            result.add(temp);
        }
        for(i=0;i<nums.length-1;i++)
        {
            temp = getRange(nums[i],nums[i+1]);
            if(temp!="")
            {
                result.add(temp);
            }
        }
        // Last element and higher
        temp = getRange(nums[nums.length-1],(long)upper+1);
        if(temp !="")
        {
            result.add(temp);
        }
        return result;
    }
    public String getLowerRange(long l,long r)
    {
        long diff,temp1,temp2;
        diff = r-l;
        if(diff == 0)
        {
            return "";
        }
        if(diff == 1)
        {
            return ""+l;
        }
        temp1 = l;
        temp2 = r-1;
        return temp1+"->"+temp2;
    }
    public String getRange(long l,long r){
        long diff,temp1,temp2;
        diff = r-l;
        System.out.println(diff);
        if(diff == 0 || diff == 1)
        {
            return "";
        }
        if(diff == 2)
        {
            temp1 = l+1;
            return ""+temp1;
        }
        temp1 = l+1;
        temp2 = r-1;
        return temp1+"->"+temp2;
    }
}
