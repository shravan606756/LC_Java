class Solution {
    public void wiggleSort(int[] arr) 
    {
        int n = arr.length;
        Arrays.sort(arr);

        int ans [] = new int[arr.length];
        int small = (n-1)/2;
        int large = n-1;

        for(int i=0 ; i<n ; i++)
        {
            if(i%2==0){
                ans[i] = arr[small--];
            }else{
                ans[i] = arr[large--];
            }
        }    

        for(int i=0 ; i<n ; i++)
        {
            arr[i] = ans[i];
        }
    }
}