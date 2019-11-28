class Solution {
    int[][] mem;
    int gMax;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
        {
            return 0;
        }
        int i,j,m,n;
        m = matrix.length;
        n = matrix[0].length;
        mem = new int[m][n];
        gMax = 0;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                gMax = Math.max(gMax,dfs(matrix,i,j,m,n));   
            }
        }
        return gMax;
    }
    
    public int dfs(int[][] matrix, int i, int j,int rows,int columns)
    {
        if(mem[i][j] > 0)
        {
            //System.out.println("here "+i+" "+j);
            return mem[i][j]; 
        }
        int cur,result = 1;
        cur = matrix[i][j];
        if(j+1<columns)
        {
            int right = matrix[i][j+1];
            if(right>cur)
                result = Math.max(result,1+dfs(matrix,i,j+1,rows,columns));
        }
        if(i+1<rows)
        {
            int bottom = matrix[i+1][j];
            if(bottom>cur)
                result = Math.max(result,1+dfs(matrix,i+1,j,rows,columns));
        }
        if(j-1>=0)
        {
            int left = matrix[i][j-1];
            if(left>cur)
                result = Math.max(result,1+dfs(matrix,i,j-1,rows,columns));
        }
        if(i-1>=0)
        {
            int top = matrix[i-1][j];
            if(top>cur)
                result = Math.max(result,1+dfs(matrix,i-1,j,rows,columns));
        }
        mem[i][j] = result;
        // for(i=0;i<rows;i++)
        // {
        //     for(j=0;j<columns;j++)
        //     {
        //         System.out.print(mem[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return result;    
    }
}
