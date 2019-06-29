class Solution {
    public int rob(int[] nums) {
        int total_money = 0;
        int i;
        if(nums.length == 0)
        {
            return 0;
        }
        if(nums.length == 1)
        {
            return nums[0];
        }
        if(nums.length == 2)
        {
            return(Math.max(nums[0],nums[1]));
        }
        if(nums[1] < nums[0])
        {
            nums[1] = nums[0];
        }
        for(i=2;i<nums.length;i++)
        {
            nums[i] = Math.max(nums[i]+nums[i-2],nums[i-1]);
        }
        return nums[nums.length-1];
    }
}
