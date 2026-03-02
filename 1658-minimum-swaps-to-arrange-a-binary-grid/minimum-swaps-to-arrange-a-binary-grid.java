class Solution {
    public int minSwaps(int[][] g) {
        int n = g.length, z[] = new int[n], ans = 0;
        
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=n-1;j>=0&&g[i][j]==0;j--) c++;
            z[i]=c;
        }
        
        for(int i=0;i<n;i++){
            int need=n-i-1, j=i;
            while(j<n && z[j]<need) j++;
            if(j==n) return -1;
            
            while(j>i){
                int t=z[j];
                z[j]=z[j-1];
                z[j-1]=t;
                j--;
                ans++;
            }
        }
        return ans;
    }
}