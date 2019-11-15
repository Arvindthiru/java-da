class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0,len,i,sum=0,diff;
        len = nums.length;
        Map<Integer,Integer> countMap = new HashMap<>();
        countMap.put(0,1);
        for(i=0;i<len;i++)
        {
            sum+=nums[i];
            if(countMap.containsKey(sum-k) == true)
            {
                count+=countMap.get(sum-k);
            }
            countMap.put(sum,countMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
