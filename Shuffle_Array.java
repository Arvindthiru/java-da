class Solution {
    int [] orig_nums;
    int [] rand_nums;
    public Solution(int[] nums) {
        int i,n;
        n = nums.length;
        orig_nums = new int[n];
        rand_nums = new int[n];
        for(i=0;i<nums.length;i++)
        {
            orig_nums[i] = nums[i];
            rand_nums[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return orig_nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int i;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(i=0;i<rand_nums.length;i++)
        {
            numbers.add(rand_nums[i]);
        }
        Collections.shuffle(numbers);
        for(i=0;i<numbers.size();i++)
        {
            rand_nums[i] = numbers.get(i);
        }
        return rand_nums;    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
