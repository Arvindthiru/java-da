class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> subset = new ArrayList<Integer>();
        getPermutations(subset,nums);
        return result;
    }
    public void getPermutations(List<Integer> subset,int[] nums)
    {
        int i;
        if(subset.size() == nums.length)
        {
            result.add(new ArrayList(subset));
            return;
        }
        for(i=0;i<nums.length;i++)
        {
            if(subset.contains(nums[i]) == false)
            {
                subset.add(nums[i]);
                getPermutations(subset,nums);
                subset.remove(subset.size()-1);
            }
        }
    }
}
