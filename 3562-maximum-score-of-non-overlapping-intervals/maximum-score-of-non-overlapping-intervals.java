class Solution {

    class node {
        long score = 0;
        List<Integer> index = new ArrayList<>();
    }

    int intervals[][];
    int n;
    int nextIdx[];
    node dp[][];

    public int[] maximumWeight(List<List<Integer>> intervalsList) {

        n = intervalsList.size();
        intervals = new int[n][4];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = intervalsList.get(i).get(0);
            intervals[i][1] = intervalsList.get(i).get(1);
            intervals[i][2] = intervalsList.get(i).get(2);
            intervals[i][3] = i;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            }

            return Integer.compare(a[3], b[3]);
        });

        nextIdx = new int[n];

        for (int i = 0; i < n; i++) {
            nextIdx[i] = findNext(intervals[i][1]);
        }

        // k can be 0,1,2,3,4
        dp = new node[n][5];

        node res = solve(intervals, 4, 0);

        int ans[] = new int[res.index.size()];

        for (int i = 0; i < res.index.size(); i++) {
            ans[i] = res.index.get(i);
        }

        return ans;
    }

    public node solve(int intervals[][], int k, int idx) {

        if (k == 0 || idx == n) {
            return new node();
        }

        if (dp[idx][k] != null) {
            return dp[idx][k];
        }

        long weight = intervals[idx][2];
        int originalIndex = intervals[idx][3];
        int nextIndex = nextIdx[idx];

        // skip

        node skip = solve(intervals, k, idx + 1);

        // take

        node temp = solve(intervals, k - 1, nextIndex);

        node take = new node();

        take.score = temp.score + weight;

        take.index = new ArrayList<>(temp.index);
        take.index.add(originalIndex);

        Collections.sort(take.index);

        // choose better

        node result;

        if (skip.score > take.score) {
            result = skip;
        }
        else if (skip.score < take.score) {
            result = take;
        }
        else {
            result = isLexSmaller(skip.index, take.index)
                    ? skip
                    : take;
        }

        dp[idx][k] = result;

        return result;
    }

    public int findNext(int x) {

        int low = 0;
        int high = n - 1;

        int res = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (intervals[mid][0] > x) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return res;
    }

    public boolean isLexSmaller(List<Integer> a, List<Integer> b) {

        int len = Math.min(a.size(), b.size());

        for (int i = 0; i < len; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}