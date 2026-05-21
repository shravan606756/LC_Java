class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        HashSet<String> set = new HashSet<>();

        for(int x : arr1)
        {
            String t = String.valueOf(x);

            for(int i=1 ; i<=t.length() ; i++)
            {
                set.add(t.substring(0,i));
            }
        }  

        int max = 0;
        for(int x : arr2)
        {
            String t = String.valueOf(x);

            for(int i=1 ; i<=t.length() ; i++)
            {
                if(set.contains(t.substring(0,i)))
                {
                    max = Math.max(max , i);
                }
            }
        }  

        return max;
    }
}