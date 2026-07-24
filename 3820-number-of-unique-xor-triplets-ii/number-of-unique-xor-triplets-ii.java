class Solution {
    public int uniqueXorTriplets(int[] arr) {

        int MAX = 2048;

        boolean[] pair = new boolean[MAX];
        boolean[] triplets = new boolean[MAX];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                pair[arr[i] ^ arr[j]] = true;
            }
        }

        for (int i = 0; i < MAX; i++) {
            if (!pair[i]) continue;

            for (int x : arr) {
                triplets[i ^ x] = true;
            }
        }

        int count = 0;
        for (boolean b : triplets) {
            if (b) count++;
        }

        return count;
    }
}