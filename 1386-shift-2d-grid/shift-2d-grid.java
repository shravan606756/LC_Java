class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        k = k % total;

        int[] arr = new int[total];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        int size = arr.length;

        for (int x = 0; x < k; x++) {
            int last = arr[size - 1];

            for (int i = size - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }

            arr[0] = last;
        }

        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = arr[idx++];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(grid[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}