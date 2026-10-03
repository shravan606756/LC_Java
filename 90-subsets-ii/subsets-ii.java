class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    int n;

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        n = arr.length;
        Arrays.sort(arr);

        solve(arr, 0);

        return res;
    }

    public void solve(int arr[], int idx)
    {
        res.add(new ArrayList<>(ans));

        for(int i=idx ; i<n ; i++)
        {
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }

            ans.add(arr[i]);
            solve(arr, i+1);

            ans.remove(ans.size()-1);
        }
    }
}