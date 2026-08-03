class Solution {
    public int findKthLargest(int[] arr, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>((a, b)->a-b);

        for(int i=0 ; i<k ; i++)
        {
            minHeap.add(arr[i]);
        }

        for(int i=k ; i<arr.length ; i++)
        {
            int x = minHeap.peek();
            if(arr[i]>x){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }
}