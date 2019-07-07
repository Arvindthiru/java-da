class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i,j,k,a;
        List<List<Integer>> solset = new ArrayList<List<Integer>>();
        Set<String> check = new TreeSet<String>();
        String key;
        List<Integer> triplet;
        if(nums.length == 0)
        {
            return solset;
        }
        Arrays.sort(nums);
        for(i=0;i<nums.length-2;i++)
        {
            a = nums[i];
            j = i+1;
            k = nums.length-1;
            while(j<k)
            {
                if(nums[j]+nums[k] == -1*a)
                {
                    key = a+":"+nums[j]+":"+nums[k];
                    if(check.contains(key) == false)
                    {
                        triplet = new ArrayList<Integer>();
                        triplet.add(a);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        solset.add(triplet);
                        check.add(key);
                    }
                    j++;
                    k--;
                }
                else if(nums[j]+nums[k] < -1*a)
                {
                    j++;
                }
                else if(nums[j]+nums[k] > -1*a)
                {
                    k--;
                }
            }
            
        }
        return solset;
    }
}
