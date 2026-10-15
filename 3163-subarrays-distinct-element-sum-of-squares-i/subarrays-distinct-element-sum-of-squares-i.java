class Solution {
    public int sumCounts(List<Integer> list) {
        int n = list.size();
        int res=0;
        
        for(int i=0 ; i<n ; i++)
        {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i ; j<n ; j++)
            {
                int currLength = j-i+1;
                map.put(list.get(j), map.getOrDefault(list.get(j), 0)+1);
                res += map.size()*map.size();
            }
        }

        return res;
    }
}