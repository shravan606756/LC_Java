class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[0]-a[0]);

        for(int i=0 ; i<arr.length ; i++)
        {
            int diff = Math.abs(arr[i]-x);
            int idx=i;

            int curr[] = {diff, idx};

            if(heap.size()<k){
                heap.add(curr);
            }else if(curr[0]<heap.peek()[0]){
                heap.poll();
                heap.add(curr);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!heap.isEmpty()){
            int temp[] = heap.poll();
            int idx = temp[1];
            res.add(arr[idx]);
        }
        Collections.sort(res);

        return res;
    }
}