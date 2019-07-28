class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small,second,i;
        small = Integer.MAX_VALUE;
        second = Integer.MAX_VALUE;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i] < small)
            {
                small = nums[i];
            }
            else if(nums[i] > small && nums[i] < second )
            {
                second = nums[i];
            }
            else if(nums[i] > second)
            {
                return true;
            }
        }
        return false;
    }
}
