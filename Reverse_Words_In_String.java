class Solution {
    
    public void reverseWord(char[] arr ,int i, int j)
    {
        char temp;
        if(i==j)
        {
            return;
        }
        while(i<j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        if(s.length() == 0)
        {
            return s;
        }
        int i=0,j;
        char[] arr = s.toCharArray();
        StringBuilder result = new StringBuilder();
        // Loop for reversing Individual words.
        while(i<arr.length)
        {
            if(arr[i] == ' ')
            {
                i++;
                continue;
            }
            j = i+1;
            while(j<arr.length)
            {
                if(arr[j]!= ' ')
                {
                    j++;
                    continue;
                }
                else
                {
                    break;
                }
            }
            reverseWord(arr,i,j-1);
            i = j;
        }
        // Loop for skipping intial spaces if any.
        i=0;
        while(i<arr.length)
        {
            if(arr[i] == ' ')
            {
                 i++;
                continue;
            }
            else
            {
                break;
            }
           
        }
        // Loop for removing intermediate spaces
        while(i<arr.length)
        {
            if(arr[i]!= ' ')
            {
                result.append(arr[i]);
                i++;
                continue;
            }
            j = i;
            while(j<arr.length)
            {
                if(arr[j] == ' ')
                {
                    j++;
                    continue; 
                }
                else
                {
                    break;
                }
            }
            i=j;
            if(i<arr.length)
            {
                result.append(' ');
            }
        }
        if(result.length() == 0)
        {
            return result.toString();
        }
        //result.deleteCharAt(result.length()-1);
        //Reverse whole String
        return result.reverse().toString();
    }
}
