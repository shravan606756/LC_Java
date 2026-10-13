class Solution {
    public long maxAlternatingSum(int[] nums) 
    {
        /*
        Queue<Long> maxHeap = new PriorityQueue<>((a, b) ->Long.compare(b, a));
        Queue<Long> minHeap = new PriorityQueue<>();
        long sum=0;
        
        for(int i=0 ; i<n ; i++){
            long x = (long) arr[i]*arr[i];
            maxHeap.offer(x);
            minHeap.offer(x);
        }    

        for (int i = 0; i < n / 2; i++) {
            sum += maxHeap.poll();
            sum -= minHeap.poll();
        }
        */
        int n = nums.length;
        long arr[] = new long[n];

        for(int i=0 ; i<n ; i++){
            arr[i] = (long) nums[i]*nums[i];
        }

        Arrays.sort(arr);
        long sum=0;

        for(int i=0 ; i<n/2 ; i++)
        {           
            sum-=arr[i];
            sum+=arr[n-1-i];
        }

        if(n%2!=0){
            sum += arr[n/2];
        }

        return sum;
    }
}