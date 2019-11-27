class Solution {
    public String largestNumber(int[] nums) {
        List<String> strNums = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            strNums.add(String.valueOf(nums[i]));
        }
        Collections.sort(strNums,new Comparator<String>(){
            public int compare(String s1,String s2)
            {
                // int a = Character.getNumericValue(s1.charAt(0));
                // int b = Character.getNumericValue(s2.charAt(0));
                // if(a!=b)
                // {
                //     return -1*(a-b);
                // }
                // else
                // {
                //     return -1*(s1.compareTo(s2));
                // }
                String a = s1+s2;
                String b = s2+s1;
                return b.compareTo(a);
            }
        });
        if(strNums.get(0).compareTo("0") == 0)
        {
            return "0";
        }
        StringBuilder s = new StringBuilder();
        for(int i=0;i<strNums.size();i++)
        {
            s.append(strNums.get(i));
        }
        return s.toString();
    }
}
