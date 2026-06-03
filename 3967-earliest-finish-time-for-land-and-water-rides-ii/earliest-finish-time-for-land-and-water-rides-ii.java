class Solution 
{
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) 
    {
        int min = Integer.MAX_VALUE;

        int f1 = giveFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        int f2 =  giveFinishTime(waterStartTime, waterDuration, landStartTime, landDuration);

        min = Math.min(min, Math.min(f1, f2));

        return min;
    }

    public int giveFinishTime(int stTime1[], int duration1[], int stTime2[], int duration2[])
    {
        int finishTime1=Integer.MAX_VALUE;

        for(int i=0 ; i<stTime1.length ; i++)
        {
            finishTime1 = Math.min(finishTime1, stTime1[i]+duration1[i]);
        }

        int finishTime2=Integer.MAX_VALUE;

        for(int i=0 ; i<stTime2.length ; i++)
        {
            finishTime2 = Math.min(finishTime2, Math.max(finishTime1, stTime2[i]) + duration2[i]);
        }

        return finishTime2;
    }
}