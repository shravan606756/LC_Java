class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                int l = landStartTime[i] + landDuration[i];
                int t1 = Math.max(l, waterStartTime[j]) + waterDuration[j];

                int w = waterStartTime[j] + waterDuration[j];
                int t2 = Math.max(w, landStartTime[i]) + landDuration[i];

                ans = Math.min(ans, Math.min(t1, t2));
            }
        }

        return ans;
    }
}