class Solution {
    public long maxAlternatingSum(int[] arr) 
    {
        int n = arr.length;
        Queue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
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

        if (n % 2 != 0) sum += maxHeap.poll();
        return sum;
    }
}