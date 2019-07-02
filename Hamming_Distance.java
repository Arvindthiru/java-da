class Solution {
    public void addZeros(List<Integer> num,int n)
    {
        int i;
        for(i=0;i<n;i++)
        {
            num.add(0);
        }
    }
    public int hammingDistance(int x, int y) {
        List<Integer> num1 = new ArrayList<Integer>();
        List<Integer> num2 = new ArrayList<Integer>();
        int d,n,i;
        if(x==0)
        {
            num1.add(0);
        }
        if(y==0)
        {
            num2.add(0);
        }
        while(x!=0)
        {
            d = x%2;
            num1.add(d);
            x = x/2;
        }
        while(y!=0)
        {
            d = y%2;
            num2.add(d);
            y=y/2;
        }
        if(num1.size()<num2.size())
        {
            n = num2.size() - num1.size();
            addZeros(num1,n);
        }
        else if(num2.size()<num1.size())
        {
            n = num1.size() - num2.size();
            addZeros(num2,n);
        }
        d=0;
        for(i=0;i<num1.size();i++)
        {
            if(num1.get(i)!=num2.get(i))
            {
                d++;
            }
        }
        return d;
            
    }
}
