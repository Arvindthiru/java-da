class Solution {
    public boolean searchFromLeft(int[][] matrix, int target)
    {
        int m,n;
        m = matrix.length-1;
        n = 0;
        while(m>=0 && n<matrix[0].length)
        {
            if(target == matrix[m][n])
            {
                return true;
            }
            if(target<matrix[m][n])
            {
                m--;
            }
            else if(target>matrix[m][n])
            {
                n++;
            }
        }
        return false;
    }
    public boolean searchFromRight(int[][] matrix , int target)
    {
        int m,n;
        m = 0;
        n = matrix[0].length-1;
        while(m<matrix.length && n>=0)
        {
            if(target == matrix[m][n])
            {
                return true;
            }
            if(target > matrix[m][n])
            {
                m++;
            }
            else if(target < matrix[m][n])
            {
                n--;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)
        {
            return false;
        }
        int left_corner,right_corner,m,n;
        boolean result;
        m = matrix.length;
        n = matrix[0].length;
        left_corner = matrix[m-1][0];
        right_corner = matrix[0][n-1];
        if(Math.abs(target-left_corner) < Math.abs(target-right_corner))
        {
            result = searchFromLeft(matrix,target);
        }
        else
        {
            result = searchFromRight(matrix,target);
        }
        return result;
    }
}
