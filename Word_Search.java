class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)
        {
            return false;
        }
        boolean result;
        int i,j,index=0;
        char[] Word = word.toCharArray();
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board[0].length;j++)
            {
                result = checkExists(board,Word,i,j,index);
                if(result == true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkExists(char[][] board, char[] Word, int i, int j,int index)
    {
        if(index == Word.length)
        {
            return true;
        }
        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1)
        {
            return false;
        }
        if(board[i][j] != Word[index])
        {
            return false;
        }
        boolean exist=false;
        if(board[i][j] == Word[index])
        {
            board[i][j] = '*';
            exist =  checkExists(board,Word,i-1,j,index+1) || checkExists(board,Word,i+1,j,index+1) || checkExists(board,Word,i,j-1,index+1) || checkExists(board,Word,i,j+1,index+1);
            board[i][j] = Word[index];
        }
        if(exist == true)
        {
            return true;
        }
        return false;
       
    }
}
