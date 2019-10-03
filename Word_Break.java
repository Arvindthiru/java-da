class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> bfsqueue = new LinkedList<>();
        Set<String> check = new HashSet(wordDict);
        int[] visited = new int[s.length()];
        int levelcount,depth,size,index;
        levelcount = 0;
        bfsqueue.add(0);
        levelcount++;
        while(bfsqueue.isEmpty()==false)
        {
            size = bfsqueue.size();
            while(size>0)
            {
                System.out.println(bfsqueue);
                index = bfsqueue.poll();
                if(visited[index] == 0)
                {
                    for(int i=index+1;i<=s.length();i++)
                    {
                        if(check.contains(s.substring(index,i)) == true)
                        {
                            bfsqueue.add(i);
                            if(i == s.length())
                            {
                                return true;
                            }
                        }
                    }
                    visited[index] = 1;
                }
                size--;
            }
        }
        return false;
    }
}
