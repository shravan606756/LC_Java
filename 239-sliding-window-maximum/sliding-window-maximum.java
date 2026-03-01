class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) 
    {
        int n = arr.length;

        Queue<int []> heap = new PriorityQueue<>(
            (a , b) -> b[0]-a[0]
        );

        int res [] = new int [n-k+1];
        int idx=0;
        for(int i=0 ; i<n ; i++)
        {
            heap.offer(new int [] {arr[i] , i});

            while(heap.peek()[1] <= i-k)
            {
                heap.poll();
            }

            if(i>=k-1)
            {
                res[idx++] = heap.peek()[0]; 
            }
        }

        return res;
    }
}