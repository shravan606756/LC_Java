class Solution {
    public int searchInsert(int[] arr, int target) {
        int n = arr.length;
        int low=0, high = n-1;
        int res=n;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]==target){
                return mid;
            }

            if(arr[mid]>target){
                res = mid;
                high = mid-1;
            }

            if(arr[mid]<target){
                low = mid+1;
            }
        }

        return res;
    }
}