import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) return false;
        
        int n = arr.length;
        int m = arr[0].length;
        int[] flat = new int[n * m];
        
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flat[k++] = arr[i][j];
            }
        }
        
        Arrays.sort(flat);
        
        int low = 0, high = flat.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (flat[mid] == target) {
                return true;
            } else if (flat[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
