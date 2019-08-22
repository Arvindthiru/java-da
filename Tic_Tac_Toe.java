class TicTacToe {
    int[] rows;
    int[] columns;
    int leftDiagonal;
    int rightDiagonal;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        leftDiagonal = 0;
        rightDiagonal = 0;
        rows = new int[n];
        columns = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int len;
        len = rows.length;
        rows[row]+= (player == 1) ? 1 : -1;
        columns[col]+= (player == 1) ? 1 : -1;
        if(row == col)
        {
            leftDiagonal+= (player == 1) ? 1 : -1;
        }
        if(col == len-1-row)
        {
            rightDiagonal+= (player == 1) ? 1 : -1; 
        }
        if(rows[row] == len || columns[col] == len || leftDiagonal == len || rightDiagonal == len)
        {
            return 1;
        }
        if(rows[row] == -len || columns[col] == -len || leftDiagonal == -len || rightDiagonal == -len)
        {
            return 2;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
