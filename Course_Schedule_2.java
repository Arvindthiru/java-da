class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adList = buildAdjList(prerequisites);
        List<Integer> tempresult = new ArrayList<>(); 
        //System.out.println(adList);
        int[] visited = new int[numCourses];
        //int[] result
        int i;
        for(i=0;i<numCourses;i++)
        {
            if(dfs(i,adList,visited,tempresult)==false)
            {
                return new int[0];
            } 
        }
        Collections.reverse(tempresult);
        int[] result = new int[tempresult.size()];
        for(i=0;i<tempresult.size();i++)
        {
            result[i] = tempresult.get(i);
        }
        return result;  
    }
    public boolean dfs(int node,Map<Integer,List<Integer>> adjlist,int[] visited,List<Integer> result)
    {
        if(visited[node] == -1)
        {
            return false;
        }
        if(visited[node] == 1)
        {
            return true;
        }
        int i;
        List<Integer> adjnodes;
        if(adjlist.containsKey(node)==true)
        {
            adjnodes = adjlist.get(node);
        }
        else
        {
            visited[node] = 1;
            result.add(node);
            return true;
        }
        visited[node] = -1;
        for(i=0;i<adjnodes.size();i++)
        {
            if(dfs(adjnodes.get(i),adjlist,visited,result)==false)
            {
                return false;
            }
        }
        visited[node] = 1;
        result.add(node);
        return true;
    }
    public Map<Integer,List<Integer>> buildAdjList(int[][] edges)
    {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> temp;
        for(int i=0;i<edges.length;i++)
        {
            if(map.containsKey(edges[i][1]) == true)
            {
                temp = map.get(edges[i][1]);
                temp.add(edges[i][0]);
            }
            else
            {
                temp = new ArrayList<>();
                temp.add(edges[i][0]);
                map.put(edges[i][1],temp);
            }
        }
        return map;
    }
}
