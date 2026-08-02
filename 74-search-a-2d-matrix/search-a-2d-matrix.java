class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        /*
            finding the appropiate row first
            then treating that row as a individual arr
            and doing bs to find target as mat is sorted
        */

        //finding row first

        int n = matrix.length;
        int m = matrix[0].length;

        int low=0, high=n-1;

        while(low<=high)
        {
            int guess = low + (high-low)/2;

            if(matrix[guess][0]>target){  
                high = guess-1;
            }else if(matrix[guess][m-1]<target){
                low = guess+1;
            }else{
                return binarySearch(matrix[guess], target);
            }
        }

        return false;
    }

    public boolean binarySearch(int arr[], int k)
    {
        int n  =arr.length;
        int low = 0, high=n-1;

        while(low<=high){
            int guess = low + (high-low)/2;

            if(arr[guess]>k){
                high = guess-1;
            }else if(arr[guess]<k){
                low = guess+1;
            }else{
                return true;
            }
        }

        return false;
    }
}