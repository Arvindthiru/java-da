class Solution {
    public int maxArea(int[] height) {
        int i,j,maxArea = 0,temp;
        i=0;
        j=height.length-1;
        while(i<j)
        {
            if(height[i]<=height[j])
            {
                temp = (j-i)*Math.min(height[i],height[j]);
                i++;
            }
            else
            {
                temp = (j-i)*Math.min(height[i],height[j]);
                j--;
            }
            maxArea = Math.max(temp,maxArea);
        }
        return maxArea;
    }
    //public int getmin
}
