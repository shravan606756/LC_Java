class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int[] oneCountPerRow = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            oneCountPerRow[i] = countOne(mat[i]);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });

        for (int i = 0; i < oneCountPerRow.length; i++) {

            int[] curr = {oneCountPerRow[i], i};

            if (heap.size() < k) {
                heap.offer(curr);
            } else {
                int[] top = heap.peek();

                if (curr[0] < top[0] ||
                    (curr[0] == top[0] && curr[1] < top[1])) {
                    heap.poll();
                    heap.offer(curr);
                }
            }
        }

        int[] res = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll()[1];
        }

        return res;
    }

    public int countOne(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if (x == 1) {
                count++;
            }
        }
        return count;
    }
}