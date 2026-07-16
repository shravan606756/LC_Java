class Solution {
    public long gcdSum(int[] arr)
    {
        int n = arr.length;
        int maxPrefix[] = new int[n];
        maxPrefix[0] = arr[0];

        for(int i=1 ; i<n ; i++){
            maxPrefix[i] = Math.max(maxPrefix[i-1], arr[i]);
        }

        for(int i=0 ; i<n ; i++)
        {
            arr[i] = gcd(arr[i], maxPrefix[i]);
        }

        Arrays.sort(arr);

        int l=0, r = n-1;
        long sum=0;
        while(l<r)
        {
            sum += (long) gcd(arr[l], arr[r]);
            l++;
            r--;
        }

        return sum;
    }

    public int gcd(int a, int b){
        while(b!=0){
            int temp = a%b;
            a=b;
            b = temp;
        }

        return a;
    }
}