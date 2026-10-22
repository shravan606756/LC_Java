class Solution {
    public int minOperations(int[] arr) {
        int n = arr.length;
        
        if (n == 1) return 0;

        int pos = -1;
        for (int i = 0; i < n; i++) 
        {
            if (arr[i] == 0) 
            {
                pos = i;
                break;
            }
        }
        
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < n; i++) {
            if (arr[(i + 1) % n] != (arr[i] + 1) % n) {
                isIncreasing = false;
            }
            if (arr[(i + 1) % n] != (arr[i] - 1 + n) % n) {
                isDecreasing = false;
            }
        }
        
        if (!isIncreasing && !isDecreasing) {
            return -1;
        }
        
        int ans = Integer.MAX_VALUE;
        
        if (isIncreasing) 
        {
            ans = Math.min(ans, pos);
            if (pos > 0) {
                ans = Math.min(ans, (n - pos) + 2);
            }
        }
        
        if (isDecreasing) 
        {
            ans = Math.min(ans, n - pos);
            ans = Math.min(ans, (pos + 1) % n + 1);
        }
        
        return ans;
    }
}