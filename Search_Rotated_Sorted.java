class Solution {
    int pivot=-1;
    int result=-1;
    public void getPivot(int[] nums, int low, int high)
    {
        if(low>high)
        {
            return;
        }
        int mid;
        mid = (low+high)/2;
        if(mid==nums.length-1)
        {
            return;
        }
        if(nums[mid] > nums[mid+1])
        {
            pivot = mid;
            return;
        }
        if(nums[mid] >= nums[low])
        {
            getPivot(nums,mid+1,high);
        }
        else
        {
            getPivot(nums,low,mid-1);
        }    
    }
    public void getTarget(int[] nums, int low, int high, int target)
    {
        if(low>high)
        {
            return;
        }
        int mid;
        mid = (low+high)/2;
        if(nums[mid] == target)
        {
            result = mid;
            return;
        }
        if(nums[mid] > target)
        {
            getTarget(nums,low,mid-1,target);
        }
        else
        {
            getTarget(nums,mid+1,high,target);
        }
        
    }
    public int search(int[] nums, int target) {
        if(nums.length == 0)
        {
            return -1;
        }
        if(nums.length == 1)
        {
            if(target == nums[0])
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
        int low=0,high=nums.length-1;
        getPivot(nums,low,high);
        if(pivot >= 0)
        {
            if(target>=nums[low] && target<=nums[pivot])
            {
                getTarget(nums,low,pivot,target);
            }
            else
            {
                getTarget(nums,pivot+1,high,target);
            }
        }
        else
        {
            getTarget(nums,low,high,target);
        }
        return result;
    }
}
