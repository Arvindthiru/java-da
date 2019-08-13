// Dynamic Programming Solution

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }
        int i,j,result=1;
        int listCount[] = new int[nums.length];
        for(i=0;i<listCount.length;i++)
        {
            listCount[i] = 1;
        }
        for(i=1;i<nums.length;i++)
        {
            for(j=0;j<i;j++)
            {
                if(nums[i] > nums[j])
                {
                    listCount[i] = Math.max(listCount[i],listCount[j]+1);
                }
            }
            if(listCount[i] > result)
            {
                result = listCount[i];
            }
        }
        for(i=0;i<listCount.length;i++)
        {
            System.out.print(listCount[i]+" ");
        }
        return result;
    }
}
