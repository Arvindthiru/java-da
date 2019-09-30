class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a1,int[] a2)
            {
                if(a1[0]<a2[0])
                {
                    return -1;
                }
                else if(a1[0]>a2[0])
                {
                    return 1;
                }
                else
                {
                    if(a1[1] < a2[1])
                    {
                        return -1;
                    }
                    else if(a1[1]>a2[1])
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
        });
        int i,j,result = 0,prev=0;
        for(i=1;i<intervals.length;i++)
        {
            if(intervals[prev][1]>intervals[i][0])
            {
                if(intervals[prev][1] <= intervals[i][1])
                {
                    result++;
                }
                else if(intervals[prev][1]>intervals[i][1])
                {
                    prev = i;
                    result++;
                }     
            }
            else
            {
                prev = i;
            }
        }
        return result;
    }
}
