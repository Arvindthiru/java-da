class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        ArrayList<Character> result = new ArrayList<Character>();
        List<Map.Entry<Character,Integer>> templist = new ArrayList<>();
        int time=0,len=0,preempt_time=0;
        Map.Entry<Character,Integer> temp;
        for(char c : tasks)
        {
            map.put(c,map.getOrDefault(c,0)+1);
            len++; 
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>(){
            public int compare(Map.Entry<Character,Integer> obj1,Map.Entry<Character,Integer> obj2)
            {
                return obj2.getValue()-obj1.getValue();
            }
        });
        for(Map.Entry<Character,Integer> elem : map.entrySet())
        {
            queue.add(elem);
        }
        while(len>0)
        {
            preempt_time = n+1;
            System.out.println(queue);
            while(queue.isEmpty() == false)
            {
                temp = queue.poll();
                map.put(temp.getKey(),map.get(temp.getKey())-1);
                result.add(temp.getKey());
                templist.add(temp);
                time++;
                len--;
                if(time == preempt_time)
                {
                    break;
                }
            }
            System.out.println(queue);
            if(len==0)
            {
                break;
            }
            while(time<preempt_time)
            {
                result.add('X');
                time++;
            }
            time = 0;
            for(Map.Entry<Character,Integer> entry : templist)
            {
                if(map.get(entry.getKey()) > 0)
                {
                    queue.add(entry);
                }
            }
            templist.clear();
            //System.out.println(queue);
        }
        System.out.println(result);
        return result.size();
    }
}
