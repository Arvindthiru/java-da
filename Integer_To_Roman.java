class Solution {
    public String intToRoman(int num) {
        ArrayList<Integer> nums = new ArrayList<>();
        Map<Integer,Character> symbols = new HashMap<>();
        symbols.put(1,'I');
        symbols.put(5,'V');
        symbols.put(10,'X');
        symbols.put(50,'L');
        symbols.put(100,'C');
        symbols.put(500,'D');
        symbols.put(1000,'M');
        int d,i,key;
        while(num!=0)
        {
            d = num%10;
            nums.add(d);
            num = num/10;   
        }
        StringBuilder s = new StringBuilder();
        for(i=nums.size()-1;i>=0;i--)
        {
            d = nums.get(i);
            key = (int)Math.pow(10,i);
            if(d == 0)
            {
                continue;
            }
            
            if(d<4)
            {
                while(d>0)
                {
                    s.append(symbols.get(key));
                    d--;
                }
            }
            if(d == 4)
            {
                s.append(symbols.get(key));
                s.append(symbols.get(5*key));
            }
            if(d>=5 && d<9)
            {
                s.append(symbols.get(5*key));
                d = d-5;
                while(d>0)
                {
                    s.append(symbols.get(key));
                    d--;
                }
            }
            if(d == 9)
            {
                s.append(symbols.get(key));
                s.append(symbols.get(10*key));
            }
        }
        return s.toString();
    }
}
