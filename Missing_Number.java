class Solution {
    public int missingNumber(int[] nums) {
        int i,truesum,sum=0,n;
        n = nums.length;
        truesum = ((n+1)*(n))/2;
        for(i=0;i<n;i++)
        {
            sum = sum + nums[i];
        }
        return truesum - sum;
    }
}
