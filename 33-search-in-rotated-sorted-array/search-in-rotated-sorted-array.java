class Solution {
    public int search(int[] nums, int target) {
        int originalFirst = getOriginalStart(nums);

        int firstHalf = searchNow(nums, target, 0, originalFirst - 1);
        int secondHalf = searchNow(nums, target, originalFirst, nums.length - 1);

        return firstHalf == -1 ? secondHalf : firstHalf;
    }

    public int getOriginalStart(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int searchNow(int[] arr, int k, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < k) {
                low = mid + 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}