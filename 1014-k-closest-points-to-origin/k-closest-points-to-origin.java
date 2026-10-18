class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        Queue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.val-a.val);
        
        for(int i=0 ; i<n ; i++)
        {
            int temp[] = points[i];
            int x = temp[0];
            int y = temp[1];

            int index = i;
            int value = x*x + y*y;

            Pair currPair = new Pair(index, value);

            if(maxHeap.size()<k){
                maxHeap.offer(currPair);
            }else{
                if(currPair.val>maxHeap.peek().val){
                    continue;
                }

                maxHeap.poll();
                maxHeap.offer(currPair);
            }
        }

        int res[][] = new int[k][2];

        for(int i=0 ; i<k ; i++)
        {
            Pair temp = maxHeap.poll();
            res[i] = points[temp.idx];  
        }

        return res;
    }

    class Pair{
        int idx, val;

        public Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}