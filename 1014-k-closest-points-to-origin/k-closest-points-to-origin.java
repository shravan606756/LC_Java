class Solution {
    public int[][] kClosest(int[][] points, int k) 
    {
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int i=0 ; i<points.length ; i++)
        {
            int index = i;
            int temp[] = points[i];
            int x = temp[0];
            int y = temp[1];

            int value =(x*x) + (y*y);

            int curr[] = {value, index};

            if(heap.size()<k){
                heap.add(curr);
            }else if(curr[0]<heap.peek()[0]){
                heap.poll();
                heap.add(curr);
            }
        }

        int res[][] = new int[k][2];
        int idx = k-1;

        while(!heap.isEmpty()){
            int temp[] = heap.poll();
            res[idx] = points[temp[1]];
            idx--;
        }

        return res;
    }
}