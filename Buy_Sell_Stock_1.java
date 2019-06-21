class Solution {
    public int maxProfit(int[] prices) {
        int i,j;
        int max_profit = 0;
        if(prices.length == 0)
        {
            return 0;
        }
        for(i=0;i<prices.length;i++)
        {
            for(j=i;j<prices.length;j++)
            {
                if(prices[j] - prices[i] > max_profit)
                {
                    max_profit = prices[j] - prices[i];
                }
            }
        }        
        return max_profit;
    }
}
