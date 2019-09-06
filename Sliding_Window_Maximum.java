class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max,i,j;
        max = 0;
        if(nums.length == 0)
        {
            return new int[0];
        }
        if(nums.length<=k)
        {
            int[] finalResult = new int[1];
            for(i=0;i<nums.length;i++)
            {
                if(nums[i]>=nums[max])
                {
                    max = i;
                    finalResult[0] = nums[max];
                }
            }
            return finalResult;
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        //For the first window
        for(i=1;i<k;i++)
        {
            if(nums[i] > nums[max])
            {
                max = i;
            }
        }
        deque.addFirst(max);
        result.add(nums[max]);
        //For the rest of the windows
        for(i=1;i<=nums.length-k;i++)
        {
            //System.out.println(deque);
            max = cleanDeque(deque,nums,i,max);
            j = i;
            while(j<i+k)
            {
                if(nums[j]>nums[max])
                {
                    deque.add(i);
                    max = j;
                }
                j++;
            }
            result.add(nums[max]);
        }
        //System.out.println(result);
        int[] finalResult = new int[result.size()];
        i=0;
        for(Integer entry : result)
        {
            finalResult[i] = result.get(i);
            i++;
        }
        return finalResult;
        
    }
    public int cleanDeque(ArrayDeque<Integer> deque,int[] nums,int i, int max)
    {

        if(deque.isEmpty()==false && deque.getFirst()<i)
        {
            deque.removeFirst();
            max = i;
            deque.addLast(i);
        }
        if(deque.isEmpty() == true)
        {
            max = i;
            deque.addLast(i);
        }
        if(deque.isEmpty() == false)
        {
            while(deque.isEmpty() == false && nums[deque.getFirst()]<nums[max])
            {
                deque.removeFirst();
            }
        }
        return max;
    }
}
