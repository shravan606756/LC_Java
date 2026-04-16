class Solution {
    public List<Integer> solveQueries(int[] arr, int[] q) 
    {
        int n = arr.length;
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<q.length;i++)
        {
            int idx = q[i];
            List<Integer> list = map.get(arr[idx]);

            if(list.size()==1)
            {
                res.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);

            int m = list.size();
            int left = list.get((pos-1+m)%m);
            int right = list.get((pos+1)%m);

            int d1 = Math.abs(idx-left);
            d1 = Math.min(d1, n-d1);

            int d2 = Math.abs(idx-right);
            d2 = Math.min(d2, n-d2);

            res.add(Math.min(d1,d2));
        }

        return res;
    }
}