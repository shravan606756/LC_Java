class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {   
        List<int[]> newNiggaGroup = new ArrayList<>();
        int n = intervals.length, i=0;
        
        while(i<n && intervals[i][0]<newInterval[0]){
            newNiggaGroup.add(intervals[i]);
            i++;
        }
        newNiggaGroup.add(newInterval);
        while(i<n){
            newNiggaGroup.add(intervals[i]);
            i++;
        }
        int niggaArr[][] = newNiggaGroup.toArray(new int[newNiggaGroup.size()][]);
        return mergeNiggers(niggaArr);
    }

    public int [][] mergeNiggers(int [][]niggers)
    {
        List<int[]> resultNigga = new ArrayList<>();
        int start1 = niggers[0][0];
        int end1 = niggers[0][1];
        
        for(int i=1 ; i<niggers.length ; i++){
            int start2 = niggers[i][0];
            int end2 = niggers[i][1];

            if(end1>=start2){
                end1 = Math.max(end1, end2);
            }else{
                resultNigga.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }
        resultNigga.add(new int[]{start1, end1});
        return resultNigga.toArray(new int[resultNigga.size()][]);
    }
}