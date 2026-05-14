import java.util.Arrays;

class Solution {
    public boolean isGood(int[] arr) {

        Arrays.sort(arr);

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != i + 1) {
                return false;
            }
        }

        return arr[n - 1] == n - 1;
    }
}