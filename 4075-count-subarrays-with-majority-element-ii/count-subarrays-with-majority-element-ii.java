class Solution {
    public long countMajoritySubarrays(int[] nums, int target) 
    {
        long res = 0;
        int cumSum = 0;
        long validLeft=0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int x : nums)
        {
            if(x==target){
                validLeft += map.getOrDefault(cumSum,0);
                cumSum++;
            }    
            else
            {
                cumSum--;
                validLeft -= map.getOrDefault(cumSum, 0);
            }

            res+=validLeft;
            map.put(cumSum, map.getOrDefault(cumSum, 0)+1);
        }     

        return res;
    }
}