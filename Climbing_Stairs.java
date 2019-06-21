class Solution {
    public int climbStairs(int n) {
        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
            return 2;
        }
        int[] steps = new int[n];
        int i;
        steps[0]=1;
        steps[1]=2;
        for(i=2;i<steps.length;i++)
        {
            steps[i] = steps[i-1]+steps[i-2];
        }
        return steps[n-1];
        
        
    }
}
