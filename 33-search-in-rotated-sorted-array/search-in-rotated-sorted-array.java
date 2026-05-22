class Solution {
    public int search(int[] arr, int target) 
    {
        int l = 0 , r = arr.length-1;

        int res = ModifiedBS(arr , target , l , r);

        return res;
    }

    public int ModifiedBS(int arr[] , int target , int l , int r)
    {
        if(l>r)
        {
            return -1;
        }

        int n = arr.length;
        int mid = l + (r-l) / 2;

        if(arr[mid]==target)
        {
            return mid;
        }

        //is in right
        if(arr[mid]>=arr[l])
        {
            if(arr[mid]>=target && arr[l]<=target)
            {
                return ModifiedBS(arr , target , l , mid-1);
            }

            else
            {
                return ModifiedBS(arr , target , mid+1 , r);
            }
        }  
        
        //is int left
        else
        {
            if(arr[mid]<=target && arr[r]>=target)
            {
               return ModifiedBS(arr , target , mid+1 , r);
            }

            else
            {
                return ModifiedBS(arr , target , l , mid-1);
            }
        }
    }
}