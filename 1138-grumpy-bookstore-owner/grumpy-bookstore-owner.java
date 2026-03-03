class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) 
    {
        int n = customers.length;

        int UnSatisfied = 0;
        int max =0;

        int high = minutes-1;

        for(int i=0 ; i<=high ; i++)
        {
            if(grumpy[i]==1)
            {
                UnSatisfied += customers[i];
            }
        }

        max = UnSatisfied ;

        int low = 0;

        while(high < n-1)
        {
            if(grumpy[low]==1)
            {
                UnSatisfied -= customers[low];
            }
            low++;
            high++;
            if(grumpy[high]==1)
            {
                UnSatisfied += customers[high];
            }

            max = Math.max(max , UnSatisfied);
        }
        
        int total = max;

        for(int i=0 ; i<n ; i++)
        {
            if(grumpy[i] == 0)
            {
                total += customers[i];
            }
        }

        return total;
    }
}