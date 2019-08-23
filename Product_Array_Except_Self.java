class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i,temp=1;
        int[] result =  new int[nums.length];
        result[0] = 1;
        for(i=1;i<result.length;i++)
        {
            result[i] = result[i-1]*nums[i-1];
        }
        for(i=nums.length-1;i>=0;i--)
        {
            result[i] = result[i]*temp;
            temp = nums[i]*temp;
        }
        return result;
    }
}
