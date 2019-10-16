class Solution {
    public int longestConsecutive(int[] nums) {
        List<Integer> candidates = new ArrayList<>();
        Set<Integer> checkSet = new HashSet<>();
        for(int elem:nums)
        {
            checkSet.add(elem);
        }
        int i,temp,count,maxCount;
        maxCount = 0;
        for(i=0;i<nums.length;i++)
        {
            if(checkSet.contains(nums[i]-1) == false)
            {
                candidates.add(nums[i]);
            }
        }
        for(i=0;i<candidates.size();i++)
        {
            temp = candidates.get(i);
            count = 0;
            while(checkSet.contains(temp) == true)
            {
                count = count+1;
                temp = temp+1;
                maxCount = Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
