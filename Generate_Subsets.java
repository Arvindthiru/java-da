class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<Integer>();
        generateSubsets(subset,nums,0);
        return result;
    }
    public void generateSubsets(List<Integer> subset,int nums[],int index)
    {
        int i;
        result.add(new ArrayList(subset));
        for(i=index;i<nums.length;i++)
        {
            subset.add(nums[i]);
            generateSubsets(subset,nums,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
