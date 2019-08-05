class Solution {
    public int findKthLargest(int[] nums, int k) {
        int count = 0,result=0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums)
        {
            pQueue.add(num);
        }
        while(count<k)
        {
            if(count == k-1)
            {
                result = pQueue.poll();
                break;
            }
            pQueue.poll();
            count++;
        }
        return result;
    }
}
