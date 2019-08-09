class Solution {
    int[] result = {-1,-1};
    public int[] searchRange(int[] nums, int target) {
        int low,high;
        low = 0;
        high = nums.length-1;
        getFirst(nums,low,high,target);
        getLast(nums,low,high,target);
        return result;
    }
    
    public void getFirst(int[] nums,int low,int high,int target)
    {
        if(low<=high)
        {
            int mid;
            mid = (low+high)/2;
            if(nums[mid] == target)
            {
                if(mid == low)
                {
                    result[0] = mid;
                    return;
                }
                if(nums[mid-1] == target)
                {
                    getFirst(nums,low,mid-1,target);
                }
                else
                {
                    result[0] = mid;
                    return;
                }
            }
            else if(nums[mid] < target)
            {
                getFirst(nums,mid+1,high,target);
            }
            else
            {
                getFirst(nums,low,mid-1,target);
            }
            
        }
    }
    public void getLast(int[] nums,int low,int high,int target)
    {
        if(low<=high)
        {
            int mid;
            mid = (low+high)/2;
            if(nums[mid] == target)
            {
                if(mid == high)
                {
                    result[1] = mid;
                    return;
                }
                if(nums[mid+1] == target)
                {
                    getLast(nums,mid+1,high,target);
                }
                else
                {
                    result[1] = mid;
                    return;
                }
            }
            else if(nums[mid] < target)
            {
                getLast(nums,mid+1,high,target);
            }
            else
            {
                getLast(nums,low,mid-1,target);
            }
            
        }
    }
}
