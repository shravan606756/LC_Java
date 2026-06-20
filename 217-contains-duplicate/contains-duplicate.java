class Solution {
    public boolean containsDuplicate(int[] arr) 
    {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = arr.length;

        for(int x : arr){
            freq.put(x, freq.getOrDefault(x, 0)+1);
        }    

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue()>1){
                return true;
            }
        }

        return false;
    }
}