class Solution {
    public int findMin(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > arr[r]) {
                l = mid + 1;
            }
            else if (arr[mid] < arr[r]) {
                r = mid;
            }
            else {
                r--;
            }
        }

        return arr[l];
    }
}