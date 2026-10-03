class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    int n;

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        n = arr.length;
        Arrays.sort(arr);

        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> finalRes = new ArrayList<>();

        solve(arr, 0);

        for(int i=0 ; i<res.size() ; i++){
            List<Integer> temp = res.get(i);

            if(set.contains(temp)){
                continue;
            }

            finalRes.add(temp);
            set.add(temp);
        }

        return finalRes;
    }

    public void solve(int arr[], int idx)
    {
        if(idx==n){
            res.add(new ArrayList<>(ans));
            return;
        }

        //skip
        solve(arr, idx+1);

        //take
        ans.add(arr[idx]);
        solve(arr, idx+1);

        ans.remove(ans.size()-1);
    }
}