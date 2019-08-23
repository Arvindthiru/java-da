class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0)
        {
            return result;
        }
        int rowBegin,colBegin,rowEnd,colEnd,i,count;
        rowBegin = 0;
        colBegin = 0;
        rowEnd = matrix.length-1;
        colEnd = matrix[0].length-1;
        count = (rowEnd+1)*(colEnd+1);
        while(count>0)
        {
            for(i=colBegin;i<=colEnd && count > 0;i++)
            {
                result.add(matrix[rowBegin][i]);
                count--;
            }
            for(i=rowBegin+1;i<=rowEnd && count >0;i++)
            {
                result.add(matrix[i][colEnd]);
                count--;
            }
            for(i=colEnd-1;i>=colBegin && count>0;i--)
            {
                result.add(matrix[rowEnd][i]);
                count--;
            }
            for(i=rowEnd-1;i>=rowBegin+1 && count>0;i--)
            {
                result.add(matrix[i][colBegin]);
                count--;
            }
            rowBegin = rowBegin+1;
            colBegin = colBegin+1;
            rowEnd = rowEnd-1;
            colEnd = colEnd-1;
        }
        return result;
    }
}
