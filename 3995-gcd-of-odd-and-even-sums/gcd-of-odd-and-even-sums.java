class Solution {
    public int gcdOfOddEvenSums(int n)
    {
        if(n==1) return 1;
        int oddSum=0;
        int evenSum=0;

        for(int i=0 ; i<n ; i++)
        {
            evenSum += 2*i;
            oddSum += 2*i-1;
        }

        return Tamatar(oddSum, evenSum);
    }

    int Tamatar(int a, int b)
    {
        while(b!=0)
        {
            int temp = a%b;
            a=b;
            b=temp;
        }

        return a;
    }
}

/*
    a,b -> b, a%b || a>b    
*/