class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i,j,k;
        if(m!=0 && n!=0)
        {
            int[] nums = new int[m];
            for(i=0;i<m;i++)
            {
                nums[i] = nums1[i];
            }
            i=0;
            j=0;
            k=0;
            while(i<m && j<n)
            {
                if(nums[i]<=nums2[j])
                {
                    nums1[k] = nums[i];
                    k++;
                    i++;
                }
                else
                {
                    nums1[k] = nums2[j];
                    k++;
                    j++; 
                }
            }
            if(i==m)
            {
                while(j<n)
                {
                    nums1[k] = nums2[j];
                    k++;
                    j++;
                }
            }
            else if(j == n)
            {
                while(i<m)
                {
                    nums1[k] = nums[i];
                    k++;
                    i++;
                }
            }
        }
        else if(m==0 && n>0)
        {
            k=0;
            j = 0;
            while(j<n)
            {
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }
    }
}
