class Solution {
    public void wiggleSort(int[] nums) {
        int flag = 0,temp;
        int i;
        for(i=1;i<nums.length;i++)
        {
            if(flag == 0)
            {
                if((nums[i-1] > nums[i]))
                {
                    temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                }
                flag = 1;
            }
            else
            {
                if(nums[i-1] < nums[i])
                {
                    temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                }
                flag = 0;
            }
        }
    }
}
