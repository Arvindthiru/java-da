class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
        {
            return new int[0];
        }
        int i;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] ans;
        dq.addLast(0);
        for(i=1;i<k;i++)
        {
            while(dq.isEmpty() == false && nums[i] >= nums[dq.getLast()])
            {
                dq.pollLast();    
            }
            dq.addLast(i);
        }
        result.add(nums[dq.getFirst()]);
        for(i=k;i<nums.length;i++)
        {
            if(dq.getFirst() <= i-k)
            {
                dq.pollFirst();
            }
            while(dq.isEmpty()==false && nums[dq.getLast()] < nums[i])
            {
                dq.pollLast();
            }
            dq.addLast(i);
            result.add(nums[dq.getFirst()]); 
        }
        ans = new int[result.size()];
        for(i = 0;i<result.size();i++)
        {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
