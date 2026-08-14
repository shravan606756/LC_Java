class Solution {
    public int[] sortedSquares(int[] arr) 
    {
        int n = arr.length;
        int idx=n-1;
        int res[] = new int[arr.length];

        int high=n-1, low=0;
        while(low<=high){
            int x = arr[high]*arr[high];
            int y = arr[low]*arr[low];

            if(x>y){
                res[idx--] = x;
                high--;
            }else{
                res[idx--] = y;
                low++;
            }
        }

        return res;
    }
}