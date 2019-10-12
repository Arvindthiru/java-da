class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i,j,k;
        int comp,tsum,result=0,diff,mindiff,flag=0;
        mindiff = Integer.MAX_VALUE;
        for(i=0;i<nums.length;i++)
        {
            comp = target - nums[i];
            j = i+1;
            k = nums.length-1;
            while(j<k)
            {
                tsum = nums[j] + nums[k];
                if(tsum == comp)
                {
                    result = nums[i] + nums[j] + nums[k];
                    flag = 1;
                    break;
                }
                diff = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                if(diff<mindiff)
                {
                    mindiff = diff;
                    result = nums[i] + nums[j] + nums[k];
                }
                if(tsum<comp)
                {
                    j++;
                }
                else if(tsum > comp)
                {
                    k--;
                }
            }
            if(flag == 1)
            {
                break;
            }
        }
        return result;
    }
}
