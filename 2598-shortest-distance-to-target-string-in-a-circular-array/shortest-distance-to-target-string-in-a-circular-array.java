class Solution {
    public int closestTarget(String[] words, String target, int startIndex) 
    {
        int n = words.length;
        int min = Integer.MAX_VALUE;
        
        for(int i=0 ; i<n ; i++)
        {
            if(words[i].equals(target))
            {
                int idx=startIndex , forward=0;

                while(idx!=i)
                {
                    idx = (idx+1)%n;
                    forward++;
                }

                int backward=0;
                idx=startIndex;
                while(idx!=i)
                {
                    idx=(idx-1+n)%n;
                    backward++;
                }
                min = Math.min(min , Math.min(forward , backward));
            }
        }
        
        if(min==Integer.MAX_VALUE)
        {
            return -1;
        }
        return min;
    }
}