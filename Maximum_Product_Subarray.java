class Solution {
    public int maxProduct(int[] nums) {
        int maxhere,minhere,result,i,temp;
        maxhere = nums[0];
        minhere = nums[0];
        result = nums[0];
        for(i=1;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                temp = maxhere;
                maxhere = minhere;
                minhere = temp;
            }
            maxhere = Math.max(nums[i]*maxhere,nums[i]);
            minhere = Math.min(nums[i]*minhere,nums[i]);
            result = Math.max(result,maxhere);
        }
        return result;

    }
}
