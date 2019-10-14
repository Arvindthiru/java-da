class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph+=".";
        int i;
        char c;
        Map<String,Integer> wordCount = new HashMap<>();
        Set<String> banset = new HashSet<>();
        for(String w : banned)
        {
            banset.add(w);
        }
        String result="";
        int maxCount,currentCount;
        maxCount = 0;
        currentCount=0;
        StringBuilder word = new StringBuilder();
        for(i=0;i<paragraph.length();i++)
        {
            c = paragraph.charAt(i);
            if(Character.isLetter(c) == true)
            {
                word.append(Character.toLowerCase(c));
            }
            else if(word.length() > 0)
            {
                String temp = word.toString();
                if(banset.contains(temp) == false)
                {
                    if(wordCount.containsKey(temp) == false)
                    {
                        wordCount.put(temp,1);
                        currentCount = 1;
                    }
                    else
                    {
                        wordCount.put(temp,wordCount.get(temp)+1);
                        currentCount = wordCount.get(temp);
                    }
                }
                if(currentCount > maxCount)
                {
                    maxCount = currentCount;
                    result = temp;
                }
                word = new StringBuilder();
            }
        }
        return result;
    }
}
