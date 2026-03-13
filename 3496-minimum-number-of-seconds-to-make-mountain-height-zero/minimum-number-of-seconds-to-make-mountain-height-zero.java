class Solution 
{
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) 
    {
        int max = 0;
        for(int x : workerTimes)
        {
            max = Math.max(max, x);
        }

        long high = (long)max * mountainHeight * (mountainHeight + 1) / 2;
        long low = 0;
        long ans = high;

        while(low <= high)
        {
            long guess = low + (high - low) / 2;

            if(canReduce(mountainHeight, workerTimes, guess))
            {
                ans = guess;
                high = guess - 1;
            }
            else
            {
                low = guess + 1;
            }
        }

        return ans;
    }

    public static boolean canReduce(int mountainHeight, int[] workerTimes, long guess)
    {
        long total = 0;

        for(int x : workerTimes)
        {
            long value = (2 * guess) / x;

            long heightReduced = (long)((-1 + Math.sqrt(1 + 4.0 * value)) / 2);

            total += heightReduced;

            if(total >= mountainHeight)
            {
                return true;
            }
        }

        return false;
    }
}