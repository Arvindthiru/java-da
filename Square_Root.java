class Solution {
    public int mySqrt(int x) {
        return findRoot(x,0,x);
    }
    
    public int findRoot(long x, long start, long end)
    {
        if(start >= end)
        {
            if(start*start == x)
            {
                return (int)start;
            }
            else if(start*start > x)
            {
                return (int)start-1;
            }
        }
        long temp,mid;
        mid = (start+end)/2;
        temp = mid*mid;
        if(temp == x)
        {
            return (int)mid;
        }
        if(temp>x)
        {
            return (int)findRoot(x,start,mid-1);
        }
        else
        {
            return (int)findRoot(x,mid+1,end);
        }
    }
}
