class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    int n;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;

        solve(candidates, target, 0, 0);
        return res;
    }

    public void solve(int arr[], int k, int idx, int currSum){
        if(currSum==k){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(idx==n || currSum>k){
            return;
        }

        solve(arr, k, idx+1, currSum);

        ans.add(arr[idx]);
        solve(arr, k, idx, currSum+arr[idx]);
        
        ans.remove(ans.size()-1);
    }
}