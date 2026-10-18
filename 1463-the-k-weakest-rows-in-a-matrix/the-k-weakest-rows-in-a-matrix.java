class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        Queue<Pair> maxHeap = new PriorityQueue<>((a, b) ->{
            if(a.val==b.val){
                return b.idx - a.idx;
            }

            return b.val - a.val;
        });

        int val[] = new int[row];
        for(int i=0 ; i<row ; i++)
        {
            val[i] = findVal(mat[i]);
        }

        for(int i=0 ; i<row ; i++)
        {
            int currVal = val[i];
            Pair currPair = new Pair(currVal, i);

            if(maxHeap.size()<k){
                maxHeap.offer(currPair);
            }else{
                if(currPair.val>maxHeap.peek().val || (
                   currPair.val==maxHeap.peek().val && currPair.idx > maxHeap.peek().idx)){
                    continue;
                }

                maxHeap.poll();
                maxHeap.offer(currPair);
            }
        }

        int res[] = new int[k];

        for(int i=k-1 ; i>=0 ; i--)
        {
            Pair temp = maxHeap.poll();
            res[i] = temp.idx;
        }

        return res;
    }

    public int findVal(int arr[])
    {
        int count= 0 ;

        for(int x : arr){
            if(x!=1){
                continue;
            }

            count++;
        }

        return count;
    }

    class Pair{
        int val;
        int idx;

        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
}