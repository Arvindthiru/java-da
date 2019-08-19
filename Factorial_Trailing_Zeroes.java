class Solution {
    public int trailingZeroes(int n) {
        int i=5,count=0;
        while(n>0)
        {
            count = count + (n/5);
            n = n/5;
        }
        return count;
    }
}
