class Solution {
    public void gameOfLife(int[][] board) {
        int i,j;
        int[] states = new int[2];
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board[0].length;j++)
            {
                states[0] = 0;
                states[1] = 8;
                getStates(board,i,j,states);
                if(board[i][j] == 1)
                {
                    if(states[0]<2)
                    {
                       board[i][j] = -1;
                    }
                    if(states[0]>3)
                    {
                        board[i][j] = -1;
                    }
                }
                else
                {
                    if(states[0]==3)
                    {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board[0].length;j++)
            {
                if(board[i][j] == 2)
                {
                    board[i][j] =1;
                }
                if(board[i][j] == -1)
                {
                    board[i][j] = 0;
                }
            }
        }
        
    }
    
    public void getStates(int[][] a,int i,int j,int[] states)
    {
        if((j+1)<a[0].length && (a[i][j+1]==1 || a[i][j+1]==-1))
        {
            states[0]++;
            states[1]--;
        }
        if((j-1)>=0 && (a[i][j-1] == 1 || a[i][j-1] == -1))
        {
            states[0]++;
            states[1]--;
        }
        if((i+1)<a.length && (a[i+1][j] == 1 || a[i+1][j]== -1))
        {
            states[0]++;
            states[1]--;
        }
        if((i-1)>=0 && (a[i-1][j] == 1 || a[i-1][j] == -1))
        {
            states[0]++;
            states[1]--;
        }
        if((i-1)>=0 && (j+1)<a[0].length && (a[i-1][j+1]==1 || a[i-1][j+1] == -1))
        {
            states[0]++;
            states[1]--;
        }
        if((i+1)<a.length && (j+1)<a[0].length && (a[i+1][j+1] == 1 || a[i+1][j+1] == -1))
        {
            states[0]++;
            states[1]--;
        }
        if((i+1)<a.length && (j-1)>=0 && (a[i+1][j-1]==1 || a[i+1][j-1]==-1))
        {
            states[0]++;
            states[1]--;
        }
        if((i-1)>=0 && (j-1)>=0 && (a[i-1][j-1]==1 || a[i-1][j-1]==-1))
        {
            states[0]++;
            states[1]--;
        }
    }
}
