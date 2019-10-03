class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> adList;
        adList = getAdjList(edges);
        int[] visited = new int[n];
        int sum,count=0;
        for(int i=0;i<n;i++)
        {
            sum = 0;
            if(visited[i] == 0)
            {
                dfs(i,adList,visited);  
                for(int j:visited)
                {
                    sum = sum+j;
                }
                if(sum == n)
                {
                    count++;
                    break;
                }
                else
                {
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int node,Map<Integer,List<Integer>> adList,int[] visited)
    {
        if(visited[node]==1 || visited[node] == -1)
        {
            return;
        }
        if(adList.containsKey(node) == false)
        {
            visited[node] = 1;
            return;
        }
        visited[node] = -1;
        List<Integer> adjNodes = adList.get(node);
        for(int i=0;i<adjNodes.size();i++)
        {
            dfs(adjNodes.get(i),adList,visited);
        }
        visited[node] = 1;
    }
    public Map<Integer,List<Integer>> getAdjList(int[][] edges)
    {
        int i;
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> temp;
        for(i=0;i<edges.length;i++)
        {
            if(map.containsKey(edges[i][0]) == false)
            {
                temp = new ArrayList<>();
                temp.add(edges[i][1]);
                map.put(edges[i][0],temp);
            }
            else
            {
                temp = map.get(edges[i][0]);
                temp.add(edges[i][1]);
            }
            if(map.containsKey(edges[i][1]) == false)
            {
                temp = new ArrayList<>();
                temp.add(edges[i][0]);
                map.put(edges[i][1],temp);
            }
            else
            {
                temp = map.get(edges[i][1]);
                temp.add(edges[i][0]);
            }
        }
        return map;
    }
}
