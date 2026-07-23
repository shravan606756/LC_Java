class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);

        res[0]=first;
        res[1] = last;

        return res;           
    }

    public int searchFirst(int nums[], int target){
        int n = nums.length;
        int low=0;
        int high=n-1;
        int start=-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int res = -1;
            if(nums[mid]<target){
                low = mid+1;
            }else if(nums[mid]>target){
                high= mid-1;
            }else{
                start = mid;
                high=mid-1;
            }
        }

        return start;
    }

    public int searchLast(int nums[], int target){
        int n = nums.length;
        int low=0;
        int high=n-1;
        int end=-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int res = -1;
            if(nums[mid]<target){
                low = mid+1;
            }else if(nums[mid]>target){
                high= mid-1;
            }else{
                end = mid;
                low=mid+1;
            }
        }

        return end;
    }
}