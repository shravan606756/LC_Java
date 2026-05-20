class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) 
    {
        int res[] = new int[A.length];

        for(int i=0 ; i<A.length ; i++)
        {
            int a[] = Arrays.copyOfRange(A , 0 , i+1);
            int b[] = Arrays.copyOfRange(B , 0 , i+1);
            int count = sameCount(a , b);
            res[i]=count;
        }

        return res;
    }

    public int sameCount(int a[] , int b[])
    {
        Arrays.sort(a);
        Arrays.sort(b);

        int i=0 , j=0 , count=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]==b[j])
            {
                count++;
                i++;
                j++;
            }

            else if(a[i]>b[j])
            {
                j++;
            }
            
            else{
                i++;
            }
        }

        return count;
    }
}