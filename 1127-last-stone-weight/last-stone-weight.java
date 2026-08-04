class Solution {
    public int lastStoneWeight(int[] stones) 
    {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b-a);

        for(int x : stones){
            heap.add(x);
        }    

        while(heap.size()>1){
            int first = heap.poll();
            int second = heap.poll();

            if(first!=second){
                heap.add(first-second);
            }
        }

        return heap.size()==0 ? 0:heap.peek();
    }
}