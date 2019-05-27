class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i,j,k,l;
        HashMap<Character,Integer> rowMap = new HashMap<>();
        HashMap<Character,Integer> columnMap = new HashMap<>();
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board.length;j++)
            {
                if(board[i][j]!='.')
                {
                    if(rowMap.containsKey(board[i][j]))
                    {
                        //System.out.print("ok1");
                        return false; 
                    }
                    rowMap.put(board[i][j],1);
                    
                } 
                if(board[j][i]!='.')
                {
                    if(columnMap.containsKey(board[j][i]))
                    {
                        //System.out.print("ok2");
                        return false;                       
                    }
                    columnMap.put(board[j][i],1);
                }
            }
            rowMap.clear();
            columnMap.clear();
        }
        rowMap.clear();
        columnMap.clear();
        //System.out.println("ok");
        for(i=0;i<board.length;i+=3)
        {
            for(j=0;j<board.length;j+=3)
            {
                //System.out.print(i);
                //System.out.print(j);
                for(k=i;k<i+3;k++)
                {
                    for(l=j;l<j+3;l++)
                    {
                        //System.out.print(board[k][l]);
                        if(board[k][l]!='.')
                        {
                            //System.out.print(board[k][l]);
                            if(rowMap.containsKey(board[k][l]))
                            {
                                return false;
                            }
                            rowMap.put(board[k][l],1);
                        }             
                    }
                }
                //System.out.print("next");
                rowMap.clear();
            }
        }
        return true;
        
        
    }
}
