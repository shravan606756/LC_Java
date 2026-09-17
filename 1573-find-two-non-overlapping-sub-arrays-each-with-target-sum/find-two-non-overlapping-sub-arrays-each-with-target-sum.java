class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int sum=0, bestMin = Integer.MAX_VALUE;
        int lastMin[] = new int[n];
        int res=Integer.MAX_VALUE, low=0;
        Arrays.fill(lastMin, Integer.MAX_VALUE);

        for(int high=0 ; high<n ; high++){
            sum += arr[high];

            while(sum>target){
                sum -= arr[low];
                low++;
            }    

            if(sum==target){
                int len = high-low+1;
                if(low>0 && lastMin[low-1]!=Integer.MAX_VALUE){
                    res =  Math.min(res, len + lastMin[low-1]);
                }

                bestMin = Math.min(bestMin, len);
            }

            lastMin[high] = bestMin;
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}