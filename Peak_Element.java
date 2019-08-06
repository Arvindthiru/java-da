class Solution {
    public int getIndex(int[] nums, int left, int right)
    {
        if(left+1==right)
        {
            if(nums[left] > nums[right])
            {
                return left;
            }
            else
            {
                return right;
            }
        }
        int mid;
        mid = (left+right)/2;
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
        {
            return mid;
        }
        else if(nums[mid+1] > nums[mid])
        {
            return getIndex(nums,mid,right);
        }
        else
        {
            return getIndex(nums,left,mid);
        }
    }
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
        {
            return 0;
        }
        int left,right,index;
        left = 0;
        right = nums.length-1;
        index = getIndex(nums,left,right);
        return index;
    }
}
