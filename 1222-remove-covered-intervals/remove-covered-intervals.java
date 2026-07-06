class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });

        List<List<Integer>> res = new ArrayList<>();

        res.add(Arrays.asList(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {
            List<Integer> last = res.get(res.size()-1);
            int l = intervals[i][0];
            int r = intervals[i][1];

            if (l >= last.get(0) && r <= last.get(1)) {
                continue;
            } else {
                res.add(Arrays.asList(l, r));
            }
        }

        return res.size();
    }
}