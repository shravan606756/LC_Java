class Solution {
    public List<Integer> targetIndices(int[] arr, int target) {
        /*Queue<Pair> minHeap = new PriorityQueue<>((a, b)->{
            if(a.val==b.val){
                return a.idx-b.idx;
            }

            return a.val-b.val;
        });

        List<Integer> res = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            minHeap.offer(new Pair(arr[i], i));
        }

        for(int i=0 ; i<n ; i++){
            Pair temp = minHeap.peek();
            if(temp.val!=target){
                minHeap.poll();
                continue;
            }
            res.add(temp.idx);
            minHeap.poll();
        }

        return res;*/

        Arrays.sort(arr);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == target){
                res.add(i);
            }
        }

        return res;
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