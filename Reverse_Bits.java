public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result,num_zeros;
        String zeros="";
        String Binary = Integer.toBinaryString(n);
        num_zeros = Binary.length();
        while(num_zeros<32)
        {
            zeros = zeros + "0";
            num_zeros++;
        }
        Binary = zeros + Binary;
        StringBuilder rev = new StringBuilder();
        rev.append(Binary);
        rev.reverse();
        result = convert_binary(rev.toString());
        return result;
    }
    public int convert_binary(String number)
    {
        int i,j=31;
        double result = 0;
        for(i=0;i<32;i++)
        {
            if(number.charAt(i) == '1' && i == 0)
            {
                result = result+Character.getNumericValue(number.charAt(i))*Math.pow(2,j);
                result = -1*result;
            }
            else
            {
                result = result+Character.getNumericValue(number.charAt(i))*Math.pow(2,j);
            }
            j--;
        }
        return (int)result;
    }
}
