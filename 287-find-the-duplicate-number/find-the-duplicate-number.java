class Solution {
    public int findDuplicate(int[] arr) 
    {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int x : arr)
        {
            freq.put(x, freq.getOrDefault(x, 0)+1);
        } 

        for(Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            int key = entry.getKey();

            if(freq.get(key)>1){
                return key;
            }
        }

        return -1;
    }
}