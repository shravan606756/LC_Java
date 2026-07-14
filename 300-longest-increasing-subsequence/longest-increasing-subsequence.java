class Solution {
    int motaHatiyar[][];
    public int lengthOfLIS(int[] arr) 
    {
        int n = arr.length;
        motaHatiyar = new int[n][n+1];

        for(int rows [] : motaHatiyar)
        {
            Arrays.fill(rows, -1);
        }

        return papaArpit(arr, 0, -1);
    }

    public int papaArpit(int arr[], int i, int prev)
    {
        if(i==arr.length){
            return 0;
        }
        if(motaHatiyar[i][prev+1]!=-1)
        {
            return motaHatiyar[i][prev+1];
        }

        int c1=0;

        if(prev==-1 || arr[prev]<arr[i])
        {
            c1 = 1 + papaArpit(arr, i+1, i);
        }

        int c2 = papaArpit(arr, i+1, prev);

        return motaHatiyar[i][prev+1] = Math.max(c1, c2);
    }
}