class Solution {
    class Coordinate{
        int x,y;
        Coordinate(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public double calculateDistance(int x, int y)
    {
        return Math.sqrt((x*x) + (y*y));
    }
    public int[][] kClosest(int[][] points, int K) {
        int i;
        Map<Double,List<Coordinate>> map = new TreeMap<>();
        List<Coordinate> temp; 
        double dist;
        for(i=0;i<points.length;i++)
        {
            dist = calculateDistance(points[i][0],points[i][1]);
            if(map.containsKey(dist) == false)
            {
                temp = new ArrayList<>();
                temp.add(new Coordinate(points[i][0],points[i][1]));
                map.put(dist,temp);
            }
            else
            {
                temp = map.get(dist);
                temp.add(new Coordinate(points[i][0],points[i][1]));
            }
        }
        int[][] ans = new int[K][2];
        int count=0,flag=0;
        for(Double d : map.keySet())
        {
            temp = map.get(d);
            for(Coordinate elem : temp)
            {
                ans[count][0] = elem.x;
                ans[count][1] = elem.y;
                count++;
                if(count == K)
                {
                    flag=1;
                    break;
                }
            }
            if(flag == 1)
            {
                break;
            }
        }
        return ans;
    }
}
