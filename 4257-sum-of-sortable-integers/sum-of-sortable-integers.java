import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums){
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int result = 0;

        for (int k = 1; k <= n; k++){
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int start = 0; start < n; start += k){
                int[] arr1 = Arrays.copyOfRange(nums, start, start + k);
                int[] arr2 = Arrays.copyOfRange(sorted, start, start + k);

                if (!isRotation(arr1, arr2)){
                    valid = false;
                    break;
                }
            }

            if (valid){
                result += k;
            }
        }

        return result;
    }

    private boolean isRotation(int[] a, int[] b){
        StringBuilder sa = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int x : a){
            sa.append(x).append(",");
        }

        for (int x : b){
            sb.append(x).append(",");
        }

        String doubled = sb.toString() + sb.toString();

        return doubled.contains(sa.toString());
    }
}