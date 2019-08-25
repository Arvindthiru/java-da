import javafx.util.Pair;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int i,j,levelcount=1,result=0,count=0;
        List<String> states;
        List<String> words;
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        Map<String,List<String>> map = new HashMap<>();
        Map<String,Integer> visited = new HashMap<>();
        Pair<String,Integer> pair;
        preProcess(map,wordList);
        queue.add(new Pair<>(beginWord,1));
        while(queue.isEmpty()==false)
        {
            while(levelcount > 0)
            {
                pair = queue.poll();
                levelcount--;
                visited.put(pair.getKey(),1);
                states = generateIntermediateStates(pair.getKey());
                for(i=0;i<states.size();i++)
                {
                    if(map.containsKey(states.get(i)) == true)
                    {
                        words = map.get(states.get(i));
                        for(j=0;j<words.size();j++)
                        {
                            if(visited.containsKey(words.get(j)) == false)
                            {
                                queue.add(new Pair<>(words.get(j),pair.getValue()+1));
                                if(words.get(j).equals(endWord) == true)
                                {
                                    result = pair.getValue()+1;
                                    break;
                                }
                                count++;
                            }
                        }
                    }
                }
            }
            if(result > 0)
            {
                break;
            }
            levelcount = count;
            count = 0;
        }
        return result;
    }
    public void preProcess(Map<String,List<String>> map,List<String> wordList)
    {
        int i,j;
        List<String> states;
        List<String> stateList;
        for(i=0;i<wordList.size();i++)
        {
            states = generateIntermediateStates(wordList.get(i));
            for(j=0;j<states.size();j++)
            {
                if(map.containsKey(states.get(j)) == true)
                {
                    stateList = map.get(states.get(j));
                    stateList.add(wordList.get(i));
                    map.put(states.get(j),stateList);
                }
                else
                {
                    stateList = new ArrayList<String>();
                    stateList.add(wordList.get(i));
                    map.put(states.get(j),stateList);
                }
            }
        }
    }
    public List<String> generateIntermediateStates(String str)
    {
        List<String> states = new ArrayList<>();
        char[] arr = str.toCharArray();
        char c;
        int i;
        for(i=0;i<arr.length;i++)
        {
            c = arr[i];
            arr[i] = '*';
            states.add(new String(arr));
            arr[i] = c;
        }
        return states;
    }
}
