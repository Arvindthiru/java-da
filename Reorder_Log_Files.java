class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,new Comparator<String>(){
            public int compare(String log1, String log2)
            {
                String[] split1 = log1.split(" ",2);
                String[] split2 = log2.split(" ",2);
                boolean dig1 = Character.isDigit(split1[1].charAt(0));
                boolean dig2 = Character.isDigit(split2[1].charAt(0));
                int comp=0;
                if(dig1!=true && dig2!=true)
                {
                    comp = split1[1].compareTo(split2[1]);
                    if(comp == 0)
                    {
                        return split1[0].compareTo(split2[0]);
                    }
                    else
                    {
                        return comp;
                    }
                }
                
                if(dig1==true && dig2 == true)
                {
                    comp = 0;
                }
                if(dig1 == true && dig2 == false)
                {
                    comp =  1;
                }
                if(dig1==false && dig2==true)
                {
                    comp = -1;
                }
                return comp;
            }
        });
      return logs;
    }
}
