class Solution {
    public String countAndSay(int n) {
        int i = 1;
        ArrayList<Integer> seq = new ArrayList<Integer>();
        String result = "";
        seq.add(1);
        if(n == 1)
        {
            return "1";
        }
        while(i<n)
        {
            seq = returnSequence(seq);
            i++;
        }
        for(i=0;i<seq.size();i++)
        {
            result = result + String.valueOf(seq.get(i));
        }
        return result;
    }
    public ArrayList<Integer> returnSequence(ArrayList<Integer> seq)
    {
        int count = 0 ,i=0,count_pos=-1;
        ArrayList<Integer> newSeq = new ArrayList<Integer>();
        for(i=0;i<seq.size();i++)
        {
            if(i == 0)
            {
                count = 1;
                count_pos = i;
                continue;
            }
            if(seq.get(i) == seq.get(count_pos))
            {
                count = count+1;
            }
            else
            {
                newSeq.add(count);
                newSeq.add(seq.get(count_pos));
                count = 1;
                count_pos = i;
            }
        }
        newSeq.add(count);
        newSeq.add(seq.get(count_pos));
        return newSeq;
    }    
}
