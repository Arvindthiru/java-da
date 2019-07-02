class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        List<Integer> row,oldrow;
        int i,j;
        for(i=0;i<numRows;i++)
        {
            if(i==0)
            {
                row = new ArrayList<Integer>();
                row.add(1);
            }
            else if(i==1)
            {
                row = new ArrayList<Integer>();
                row.add(1);
                row.add(1);
            }
            else
            {
                row = new ArrayList<Integer>();
                oldrow = allrows.get(i-1);
                row.add(1);
                for(j=0;j<oldrow.size()-1;j++)
                {
                    row.add(oldrow.get(j)+oldrow.get(j+1));
                }
                row.add(1);
            }
            allrows.add(row);
        }
        return allrows;
    }
}
