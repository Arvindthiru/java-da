/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int mid,pos=-1;
        long left,right,lmid;
        mid = 0;
        left = 1;
        right = n;
        if(n==1)
        {
            return 1;
        }
        while(left<=right)
        {
            lmid = (left+right)/2;
            mid = (int)lmid;
            if(isBadVersion(mid) == true && isBadVersion(mid-1) == true)
            {
                right = mid-1;
            }
            else if(isBadVersion(mid) == true && isBadVersion(mid-1) == false)
            {
                return mid;
            }
            if(isBadVersion(mid) == false)
            {
                left = mid+1;
            }
        }
        return mid;
        
    }
}
