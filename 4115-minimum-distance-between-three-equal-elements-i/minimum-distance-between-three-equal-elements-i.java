import java.util.*;

class Solution {
    public int minimumDistance(int[] arr) 
    {
        int n = arr.length;

        Map<Integer , Integer> freq = new HashMap<>();

        for(int x : arr)
        {
            freq.put(x , freq.getOrDefault(x,0)+1);
        }        

        int min = Integer.MAX_VALUE;
        
        for(int x : freq.keySet())
        {
            if(freq.get(x) >= 3)
            {
                List<Integer> tuple = new ArrayList<>();

                for(int i = 0 ; i < n ; i++)
                {
                    if(arr[i] == x)
                    {
                        tuple.add(i);
                    }
                }

                // check all consecutive triples
                for(int i = 0; i <= tuple.size() - 3; i++)
                {
                    int first = tuple.get(i);
                    int third = tuple.get(i + 2);

                    int distance = 2 * (third - first);

                    min = Math.min(min, distance);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}