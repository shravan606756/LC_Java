class Solution {
    public int shortestSubarray(int[] arr, int k) 
    {
        int n = arr.length;
        int prefix[] = new int[n];
        Deque<Integer> deq = new ArrayDeque<>();
        int minLength = Integer.MAX_VALUE, i=0;

        while(i<n)
        {
            if(i==0){
                prefix[i] = arr[0];
            }else{
                prefix[i] = prefix[i-1] + arr[i];
            }

            if (prefix[i] >= k) {
                minLength = Math.min(minLength, i + 1);
            }

            while(!deq.isEmpty() && prefix[i]-prefix[deq.peekFirst()]>=k){
                minLength = Math.min(minLength, i - deq.peekFirst());
                deq.pollFirst();
            }

            while(!deq.isEmpty() && prefix[i]<=prefix[deq.peekLast()]){
                deq.pollLast();
            }

            deq.offer(i);
            i++;
        }

        return minLength==Integer.MAX_VALUE  ? -1 : minLength;
    }
}