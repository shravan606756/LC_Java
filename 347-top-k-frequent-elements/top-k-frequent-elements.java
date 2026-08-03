class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        Queue<Pair> heap = new PriorityQueue<>((a,b)->{
            if(a.frequency==b.frequency){
                return a.number-b.number;
            }else{
                return a.frequency-b.frequency;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();

        for(int x : arr){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();

            Pair curr = new Pair(freq, key);

            if(heap.size()<k){
                heap.add(curr);
            }else{
                if(curr.frequency<heap.peek().frequency){
                    continue;
                }

                heap.poll();
                heap.add(curr);
            }
        }

        int res[] = new int[k];

        for(int i=k-1 ; i>=0 ; i--)
        {
            res[i] = heap.poll().number;
        }

        return res;
    }
}
 
class Pair {
    int frequency =0;
    int number = 0;

    public Pair(int frequency, int number) {
        this.frequency = frequency;
        this.number = number;
    }
}