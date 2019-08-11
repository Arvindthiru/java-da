class Solution {
    public void sortColors(int[] nums) {
        int low =0,mid=0,high=nums.length-1,temp;
        if(nums.length <= 1)
        {
            return;
        }
        while(mid<=high)
        {
            if(nums[mid] == 0)
            {
                if(mid == low)
                {
                    mid++;
                    low++;
                    continue;
                }
                temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                if(nums[mid] == 1)
                {
                    mid++;
                }
                else
                {
                    continue;
                }
               
            }
            else if(nums[mid] == 2)
            {
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
                if(nums[mid] == 1)
                {
                    mid++;
                }
                else
                {
                    continue;
                }
            }
            else if(nums[mid] == 1)
            {
                mid++;
            }
        }      
    }
}
