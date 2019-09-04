class Solution {
    public int findDuplicate(int[] nums) {
        int index=0,jump=-1;
        while(true)
        {
            if(nums[index] == -1)
            {
                break;
            }
            jump = nums[index];
            nums[index] = -1;
            index = jump; 
        }
        return index;
    }
}
