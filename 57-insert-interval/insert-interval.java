class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {   
        Arrays.sort(intervals, (x,y)->x[0]-y[0]);

        List<int[]> arr = new ArrayList<>();
        int n = intervals.length;
        int idx=0;
        while(idx<n && intervals[idx][0]<newInterval[0]){
            arr.add(intervals[idx]);
            idx++;
        }

        arr.add(newInterval);
        
        while(idx<n){
            arr.add(intervals[idx]);
            idx++;
        }

        int [][] newArr = arr.toArray(new int[arr.size()][]);
        return merge(newArr);
    }

    public int[][] merge(int arr[][]){
        Arrays.sort(arr, (x, y) -> x[0]-y[0]);
        List<int[]> res = new ArrayList<>();

        int n = arr.length;
        int start1 = arr[0][0];
        int end1 = arr[0][1];

        for(int i=1 ; i<n ; i++){
            int start2 = arr[i][0];
            int end2 = arr[i][1];

            if(start2<=end1){
                end1 = Math.max(end1, end2);
            }else{
                res.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }

        res.add(new int[]{start1, end1});
        return res.toArray(new int[res.size()][]);
    }
}