class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
        {
            return 0;
        }
        int i=0,endpos=0,rooms=0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int[] interval : intervals)
        {
            start[i] = interval[0];
            end[i] = interval[1];
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(i=0;i<start.length;i++)
        {
            if(start[i] < end[endpos])
            {
                rooms++;
            }
            else
            {
                endpos++;
            }
        }
        return rooms;
    }
}
