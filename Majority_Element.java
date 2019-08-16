class Solution {
    public int majorityElement(int[] nums) {
        //Using Moore's Voting Algorithm
        int count = 1,i,majIndex=0;
        for(i=1;i<nums.length;i++)
        {
            if(nums[i] == nums[majIndex])
            {
                count++;
            }
            else
            {
                count--;
                if(count==0)
                {
                    majIndex = i;
                    count = 1;
                }
                
            }
        }
        return nums[majIndex];
    }
}
