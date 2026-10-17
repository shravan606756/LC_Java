class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)->{
            int x = digitSum(a), y = digitSum(b);

            if(x!=y){
                return x-y;
            }
            
            return a-b;            
        });

        for(int x : arr){
            minHeap.add(x);
        }

        int sorted[] = new int[n];
        for(int i=0 ; i<n ; i++){
            sorted[i] = minHeap.poll();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(arr[i], i);
        }
        
        int swaps=0;
        for(int i=0 ; i<n ; i++)
        {
            if(arr[i]!=sorted[i]){
                int j = map.get(sorted[i]);
                map.put(arr[i], j);
                map.put(sorted[i], i);
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                swaps++;
            }
        }

        return swaps;
    }

    public int digitSum(int x)
    {
        int sum=0;

        while(x>0){
            int digit = x%10;
            sum += digit;
            x /= 10;
        }

        return sum;
    }
}