class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j,m,n,rowflag=1,colflag=1;
        m = matrix.length;
        n = matrix[0].length;
        for(i=0;i<n;i++)
        {
            if(matrix[0][i] == 0)
            {
                rowflag = 0;
                break;
            }
        }
        for(i=0;i<m;i++)
        {
            if(matrix[i][0] == 0)
            {
                colflag = 0;
                break;
            }
        }
        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowflag == 0)
        {
            for(i=0;i<n;i++)
            {
                matrix[0][i] = 0;
            }
        }
        if(colflag == 0)
        {
            for(i=0;i<m;i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
