class Solution {
    public int firstMissingPositive(int[] nums) {
        int oneFlag = 0,i,index;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i] == 1)
            {
                oneFlag = 1;
            }
            if(nums[i] > nums.length || nums[i] <=0)
            {
                nums[i] = 1;
            }
        }
        if(oneFlag == 0)
        {
            return 1;
        }
        if(nums.length == 1)
        {
            return nums[0]+1;
        }
        
        for(i=0;i<nums.length;i++)
        {
            index = Math.abs(nums[i]);
            if(index == nums.length)
            {
                nums[0] = -1*nums[0];
                continue;
            }
            if(nums[index] > 0)
                nums[index]  = -1*nums[index];
        }
        for(i=1;i<nums.length;i++)
        {
            if(nums[i] > 0)
            {
                return i;
            }
        }
        if(nums[0] < 0)
        {
            return nums.length+1;
        }
        return nums.length;
    }
}
