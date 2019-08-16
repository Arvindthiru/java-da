class Solution {
    public int titleToNumber(String s) {
        int c,sum=0,i=0;
        char[] arr = s.toCharArray();
        int n = arr.length-1;
        while(n>=0)
        {
            c = (arr[i] - 'A') + 1;
            sum = sum + c*(int)Math.pow(26,n);
            n--;
            i++;
        }
        return sum;
    }
}
