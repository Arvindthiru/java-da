class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
        {
            return 0;
        }
        if(coins.length == 0)
        {
            return -1;
        }
        int i,j,remainder;
        int[] mem = new int[amount+1];
        mem[0] = 0;
        for(i=1;i<mem.length;i++)
        {
            mem[i] = Integer.MAX_VALUE;
            for(j=0;j<coins.length;j++)
            {
                remainder = i-coins[j];
                if(remainder >= 0)
                {
                    if(mem[remainder] < Integer.MAX_VALUE)
                    {
                       mem[i] = Math.min(mem[i],mem[remainder]+1); 
                    } 
                }
            }
        }
        if(mem[mem.length-1] == Integer.MAX_VALUE)
        {
            return -1;
        }
        return mem[mem.length-1];
        
    }
}
