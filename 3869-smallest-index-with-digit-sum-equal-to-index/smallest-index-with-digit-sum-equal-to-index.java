class Solution {
    public int smallestIndex(int[] arr)
    {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int idx=-1;

        for(int i=0 ; i<n ; i++){
            int sum = sumOfValue(arr[i]);

            if(sum!=i){
                continue;
            }

            if(sum<min){
                min = sum;
                idx = i;
            }
        }    

        return idx;
    }

    public int sumOfValue(int n){
        if(n<10){
            return n;
        }

        int sum=0;
        while(n>0){
            int digit = n%10;
            sum += digit;
            n /= 10;
        }   

        return sum;
    }
}