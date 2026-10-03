class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        Arrays.sort(candidates);

        solve(candidates, target, 0, 0);

        /*List<List<Integer>> finalRes = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0 ; i<res.size() ; i++){
            List<Integer> temp = res.get(i);

            if(set.contains(temp)){
                continue;
            }
            set.add(temp);
            finalRes.add(temp);
        }
        return finalRes;*/
        
        return res;
    }

    public void solve(int arr[], int k, int idx, int currSum){
        if(currSum==k){
            res.add(new ArrayList<>(ans));
            return;
        }

        /*if(idx==n || currSum>k){
            return;
        }

        //skip
        solve(arr, k, idx+1, currSum);

        //take
        ans.add(arr[idx]);
        solve(arr, k, idx+1, currSum+arr[idx]);

        //BT
        ans.remove(ans.size()-1);*/

        for(int i=idx ; i<n ; i++)
        {
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }
            if(currSum>k){
                break;
            }

            ans.add(arr[i]);
            solve(arr, k, i+1, currSum+arr[i]);
            ans.remove(ans.size()-1);
        }
    }
}