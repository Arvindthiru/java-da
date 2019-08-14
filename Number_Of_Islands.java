class Solution {
    public int numIslands(char[][] grid) {
        int i,j,count=0;
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    DFS(grid,i,j);
                }
            }
        }
        return count;
    }
    public void DFS(char[][] grid,int i,int j)
    {
        if(i<0 || j<0 || i>grid.length-1 || j> grid[0].length-1)
        {
            return;
        }
        if(grid[i][j] == '0')
        {
            return;
        }
        if(grid[i][j] == '1')
        {
            grid[i][j] = '0';
            DFS(grid,i-1,j);
            DFS(grid,i+1,j);
            DFS(grid,i,j-1);
            DFS(grid,i,j+1);
        }
    }
}
