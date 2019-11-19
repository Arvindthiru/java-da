class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        int i,j,k,firstBracketIndex=0,secondBracketIndex=0;
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> directoryMap = new HashMap<>();
        List<String> temp;
        String str,key,file,totalPath;
        for(i=0;i<paths.length;i++)
        {
            String[] splitElems = paths[i].split(" ");
            for(j=1;j<splitElems.length;j++)
            {
                str = splitElems[j];
                for(k=0;k<str.length();k++)
                {
                    if(str.charAt(k) =='(')
                    {
                        firstBracketIndex = k;
                    }
                    if(str.charAt(k) == ')')
                    {
                        secondBracketIndex = k;
                    }
                }
                file = str.substring(0,firstBracketIndex);
                key = str.substring(firstBracketIndex+1,secondBracketIndex);
                totalPath = splitElems[0]+"/"+file;
                if(directoryMap.containsKey(key) == false)
                {
                    temp = new ArrayList<>();
                    temp.add(totalPath);
                    directoryMap.put(key,temp);
                }
                else
                {
                    temp = directoryMap.get(key);
                    temp.add(totalPath);
                }
            }   
        }
        for(Map.Entry<String,List<String>> elem : directoryMap.entrySet())
        {
            temp = elem.getValue();
            if(temp.size()>1)
            {
                result.add(elem.getValue()); 
            }
        }
        return result;
    }    
}
