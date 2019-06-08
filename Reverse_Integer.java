class Solution {
    public int reverse(int x) {
        int Max_Positive,Max_Negative;
        Max_Positive = (int)Math.pow(2,31) - 1;
        Max_Negative = (int)Math.pow(-2,31);
        int sign = 1,power,d,i;
        long sum = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        if(x > 0)
        {
            sign = 1;
        }
        else
        {
            sign = -1;
        }
        while(x!=0)
        {
            d = x%10;
            x = x/10;
            if(d<0)
            {
                d = d*-1;
            }
            nums.add(d);
        }
        power = nums.size()-1;
        for(i=0;i<nums.size();i++)
        {
            sum = sum + (long)nums.get(i)*(int)Math.pow(10,power);
            power--;
        }
        if(sign == -1)
        {
            sum = sum*-1;
        }
        if(sum > Max_Positive)
        {
            return 0;
        }
        if(sum < Max_Negative)
        {
            return 0;
        }
        return (int)sum;
        
    }
}
