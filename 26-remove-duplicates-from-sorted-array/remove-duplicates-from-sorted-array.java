class Solution {
    public int removeDuplicates(int[] arr) 
    {
        int n = arr.length;
        List<Integer> res=  new ArrayList<>();
        res.add(arr[0]);

        for(int i=1 ; i<n ; i++){
            if(arr[i-1]!=arr[i]){
                res.add(arr[i]);
            }
        }

        int k = res.size();

        for (int i = 0; i < k; i++) {
            arr[i] = res.get(i);
        }

        return k;
    }
}