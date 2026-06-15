class Solution {
    public int totalFruit(int[] fruits) 
    {
        Map<Integer, Integer> freq = new HashMap<>();
        int low=0, max = Integer.MIN_VALUE;

        for(int high=0 ; high<fruits.length ; high++)
        {
            freq.put(fruits[high], freq.getOrDefault(fruits[high], 0)+1);

            while(freq.size()>2)
            {
                int d = fruits[low];
                int count = freq.get(d);
                count--;

                if(count==0){
                    freq.remove(d);
                }else{
                    freq.put(d, count);
                }

                low++;
            }

            if(freq.size()<=2){
                int len = high-low+1;
                max = Math.max(max, len);
            }
        }    

        return max==Integer.MIN_VALUE ? 0:max;
    }
}