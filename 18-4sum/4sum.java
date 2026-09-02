class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target)
    {
        Arrays.sort(arr);

        int n = arr.length;
        Set<List<Integer>> res = new HashSet<>();

        for(int i=0 ; i<n-3 ; i++)
        {
            for(int j=i+1 ; j<n-2 ; j++){
                int l = j+1;
                int r = n-1;

                while(l<r){
                    long sum = (long) arr[i]+arr[j]+arr[l]+arr[r];
                    if(sum==target){
                        res.add(Arrays.asList(arr[i], arr[j], arr[l], arr[r]));
                        l++;
                        r--;
                    }else if(sum>target){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }  

        return new ArrayList<>(res);
    }
}