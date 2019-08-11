//Recursive DFS solution

class Solution {
    List<String> result = new ArrayList<>();
    
    public void getCombinations(String digits, Map<Character,String> map, StringBuilder combination, int index)
    {
        if(index == digits.length())
        {
            result.add(combination.toString());
            return;
        }
        int i;
        String mapping = map.get(digits.charAt(index));
        for(i=0;i<mapping.length();i++)
        {
            combination.append(mapping.charAt(i));
            getCombinations(digits,map,combination,index+1);
            combination.deleteCharAt(combination.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        int index = 0;
        if(digits.length() == 0)
        {
            return result;
        }
        Map<Character,String> map = new HashMap<>();
        StringBuilder combination = new StringBuilder();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        getCombinations(digits,map,combination,index);
        return result;
    }
}
