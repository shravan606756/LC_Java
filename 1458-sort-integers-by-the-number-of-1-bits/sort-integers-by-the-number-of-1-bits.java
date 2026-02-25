class Solution {
    public int[] sortByBits(int[] arr) 
    {
        int n = arr.length;

        Queue<int[]> heap = new PriorityQueue<>(
            (a,b) -> {
                if(a[1]==b[1])
                {
                    return a[0]-b[0];
                }

                return a[1]-b[1];
            }
        );

        for(int x : arr)
        {
            heap.add(new int [] {x , CountOne(x)});
        }

        int i=0;
        int res [] = new int [heap.size()];
        while(heap.size()!=0)
        {
            res[i++] = heap.poll()[0]; 
        }

        return res;
    }

    int CountOne(int n)
    {
        int count=0;

        while(n>0)
        {
            count+=n&1;
            n>>=1;
        }

        return count;
    }
}