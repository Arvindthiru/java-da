class Solution {
    public int[] plusOne(int[] digits) {
        int size,new_size;
        size = digits.length;
        int carry = 0;
        int i;
        for(i=size-1;i>=0;i--)
        {
            if(digits[i] < 9)
            {
                digits[i] = digits[i] + 1;
                carry = 0; 
                break;
            }
            else
            {
                digits[i] = 0;
                carry = 1;
            }
        }
        if(carry == 1)
        {
            new_size = size + 1;
            int new_digits[] = new int[new_size];
            new_digits[0] = 1;
            for(i=0;i<size;i++)
            {
                new_digits[i+1] = digits[i];
            }
            return new_digits;
        }
        return digits;
        
    }
}
