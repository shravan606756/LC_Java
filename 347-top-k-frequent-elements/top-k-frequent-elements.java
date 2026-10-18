class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        int n = arr.length;

        Queue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> {
                int x = a.freq, y = b.freq;
                if(x!=y){
                    return x-y;
                }
                return a.number - b.number;
            }
        );

        Map<Integer, Integer> map = new HashMap<>();

        for(int x : arr){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            Pair currPair = new Pair(key, val);

            if(minHeap.size()<k){
                minHeap.offer(currPair);
            }else{
                if(minHeap.peek().freq > currPair.freq){
                    continue;
                }
                minHeap.poll();
                minHeap.offer(currPair);
            }
        }

        int res[] = new int[k];

        for(int i=0 ; i<k ; i++){
            res[i] = minHeap.poll().number;
        }

        return res;
    }

    class Pair{
        int number, freq;
        public Pair(int number, int freq){
            this.number = number;
            this.freq = freq;
        }
    }
}