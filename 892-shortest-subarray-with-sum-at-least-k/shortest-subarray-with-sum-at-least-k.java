class Solution {
    public int shortestSubarray(int[] arr, int k) 
    {
        Deque<Integer> deq = new LinkedList<>();
        int prefix[] = new int[arr.length];

        int low=0, res = Integer.MAX_VALUE, i=0;

        while(i<arr.length)
        {
            if(i==0){
                prefix[i] = arr[0];
            }

            else prefix[i] = prefix[i-1]+arr[i];

            if(prefix[i]>=k){
                res = Math.min(res, i+1);
            }

            //shrinking
            while(!deq.isEmpty() && prefix[i]-prefix[deq.peekFirst()]>=k)
            {
                res = Math.min(res, i-deq.peekFirst());
                deq.pollFirst();
            }

            //maintaing monotonic behaviour
            while(!deq.isEmpty() && prefix[i]<=prefix[deq.peekLast()]){
                deq.pollLast();
            }

            deq.offerLast(i);
            i++;
        }   

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}