// Floyd Cycle detection algorithm
class Solution {
    public boolean isHappy(int n) {
        int slow,fast;
        slow = fast = n;
        
        do
        {
            slow = squareDigits(slow);
            fast = squareDigits(squareDigits(fast));
        }while(slow!=fast);
        
        if(slow == 1)
        {
            return true;
        }
        return false;
    }
    
    public int squareDigits(int n)
    {
        int sum = 0,d;
        while(n>0)
        {
            d = n%10;
            n = n/10;
            sum = sum + (d*d);
        }
        return sum;
    }
}
