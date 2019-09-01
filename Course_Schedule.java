class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjList;
        adjList = buildAdjList(prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] finished = new boolean[numCourses];
        boolean result;
        System.out.println(adjList);
        for(Map.Entry<Integer,List<Integer>>entry : adjList.entrySet())
        {
            if(finished[entry.getKey()] == false)
            {
                result = dfsGraph(adjList,visited,finished,entry.getKey(),entry.getValue());
                if(result == true)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Map<Integer,List<Integer>> buildAdjList(int[][] prerequisites)
    {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> l;
        for(int[] arr : prerequisites)
        {
            if(map.containsKey(arr[1]) == true)
            {
                l = map.get(arr[1]);
                l.add(arr[0]);
            }
            else
            {
                l = new ArrayList<>();
                l.add(arr[0]);
                map.put(arr[1],l);
            }
        }
        return map;
    }
    
    public boolean dfsGraph(Map<Integer,List<Integer>> adjList,boolean[] visited, boolean[] finished, int node, List<Integer> adjNodes )
    {
        int i;
        boolean result;
        visited[node] = true;
        for(i=0;i<adjNodes.size();i++)
        {
            if(finished[adjNodes.get(i)] == false && visited[adjNodes.get(i)] == false)
            {
                if(adjList.containsKey(adjNodes.get(i)) == true)
                {
                    result = dfsGraph(adjList,visited,finished,adjNodes.get(i),adjList.get(adjNodes.get(i)));
                    if(result == true)
                    {
                        return true;
                    }
                }
                else
                {
                    visited[adjNodes.get(i)] = true;
                    finished[adjNodes.get(i)] = true;
                    continue;
                }
            }
            if(visited[adjNodes.get(i)] == true && finished[adjNodes.get(i)] == false)
            {
                return true;
            }
        }
        finished[node] = true;
        return false;
    }
}
