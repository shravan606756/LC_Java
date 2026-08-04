class Solution {
    public int kthSmallest(int[][] matrix, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int[] row : matrix) {
            for (int num : row) {

                if (heap.size() < k) {
                    heap.offer(num);
                } else if (num < heap.peek()) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }

        return heap.peek();
    }
}