class Solution {
    public int trap(int[] height) {
        if(height.length==0)
        {
            return 0;
        }
        int i,max,total;
        total = 0;
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        leftmax[0] = height[0];
        rightmax[rightmax.length-1] = height[height.length-1];
        max = leftmax[0];
        for(i=1;i<height.length;i++)
        {
            leftmax[i] = max;
            if(height[i]>=max)
            {
                max = height[i];
            }
        }
        max = rightmax[rightmax.length-1];
        for(i=rightmax.length-2;i>=0;i--)
        {
            rightmax[i] = max;
            if(height[i]>=max)
            {
                max = height[i];
            }
        }
        for(i=0;i<height.length-1;i++)
        {
            if(height[i]<Math.min(leftmax[i],rightmax[i]))
            {
                total+=Math.min(leftmax[i],rightmax[i])-height[i];
            }
        }
        return total;
    }
}
