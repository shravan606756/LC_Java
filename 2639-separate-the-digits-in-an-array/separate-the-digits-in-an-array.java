class Solution {
    public int[] separateDigits(int[] arr) 
    {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for(int i=0 ; i<n ; i++)
        {
            String x = String.valueOf(arr[i]);
            
            for(int j=0 ; j<x.length() ; j++)
            {
                res.add(x.charAt(j)-'0');
            }
        }    

        int ans [] = new int[res.size()];

        for(int i=0 ; i<res.size() ; i++)
        {
            ans[i]=res.get(i);
        }

        return ans;
    }
}