class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        HashMap<Integer,Integer> track = new HashMap<>();
        int i,s,diff;
        s = nums.length;
        for(i=0;i<s;i++)
        {
            if(track.containsKey(nums[i]))
            {
                indexes.add(track.get(nums[i]));
                indexes.add(i);
                
            }
            diff = target - nums[i];
            track.put(diff,i);
           
        }
        int[] index = new int[indexes.size()];
        for(i=0;i<indexes.size();i++)
        {
            index[i] = indexes.get(i);
        }
        return index;      
    }
}
