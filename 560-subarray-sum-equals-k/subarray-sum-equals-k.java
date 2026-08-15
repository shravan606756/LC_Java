class Solution {
    public int subarraySum(int[] arr, int k) 
    {
        int n = arr.length;
        int res=0, sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0 ; i<n ; i++)
        {
            sum += arr[i];
            int wrong = sum-k;
            int wrongCount = map.getOrDefault(wrong, 0);

            if(wrongCount>=1){
                res += wrongCount;
            }

            map.put(sum, map.getOrDefault(sum,  0)+1);
        } 

        return res;
    }
}