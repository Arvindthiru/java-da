class Solution {
    public int uniquePaths(int m, int n) {
        int i,j;
        int[][] pathCount = new int[m][n];
        for(i=0;i<m;i++)
        {
            pathCount[i][0] = 1;
        }
        for(j=0;j<n;j++)
        {
            pathCount[0][j] = 1;
        }
        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                pathCount[i][j] = pathCount[i-1][j] + pathCount[i][j-1];
            }
        }
        return pathCount[m-1][n-1];
        
    }
}
