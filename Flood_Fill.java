class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        image = dfs(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    
    public int[][] dfs(int[][] image,int i,int j,int prevColor,int newColor)
    {
        if(i>=0 && i<image.length && j>=0 && j<image[0].length)
        {
            if(image[i][j] == prevColor)
            {
                image[i][j] = -1;
                dfs(image,i+1,j,prevColor,newColor);
                dfs(image,i-1,j,prevColor,newColor);
                dfs(image,i,j+1,prevColor,newColor);
                dfs(image,i,j-1,prevColor,newColor);
                image[i][j] = newColor;
            }
        }
        return image;
    }
}
