class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int low=0, high=n-1;
        boolean isEven;

        while(low<high){
            int mid = low + (high-low)/2;

            if((high-mid)%2==0){
                isEven=true;
            }else{
                isEven=false;
            }

            if(arr[mid]==arr[mid+1]){
                if(isEven==true){
                    low = mid+2;
                }else{
                    high = mid-1;
                }
            }

            else{
                if(isEven==true){
                    high = mid;
                }else{
                    low = mid+1;
                }
            }
        }

        return arr[low];
    }
}