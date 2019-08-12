//Dynamic Programming Solution

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
        {
            return true;
        }
        if(nums[0] == 0)
        {
            return false;
        }
        int i,j;
        int[] jumps = new int[nums.length];
        for(i=1;i<nums.length;i++)
        {
            jumps[i] = Integer.MAX_VALUE;
            for(j=0;j<i;j++)
            {
                if(nums[j]+j >= i)
                {
                    jumps[i] = Math.min(jumps[i],jumps[j]+1);
                }
                
            }
            if(jumps[i] == Integer.MAX_VALUE)
            {
                return false;
            }
        }
        if(jumps[nums.length-1] < Integer.MAX_VALUE)
        {
            return true;
        }
        return false;    
    }
}
