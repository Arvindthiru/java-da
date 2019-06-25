class Solution {
    public int maxSubArray(int[] nums) {
        int i,max_here,max_so_far,sum;
        max_here = nums[0];
        max_so_far = nums[0];
        sum = nums[0];
        for(i=1;i<nums.length;i++)
        {
            sum = sum +nums[i];
            if(nums[i] > sum)
            {
                sum = nums[i];
                max_here = nums[i];
            }
            if(sum >= nums[i])
            {
                max_here = sum;
            }
            max_so_far = Math.max(max_here,max_so_far);
        }
        return max_so_far;
        
    }
}
