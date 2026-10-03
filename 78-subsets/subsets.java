class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] arr) 
    {
        int n = arr.length;

        sol(arr, 0, n);
        return res;
    }

    public void sol(int arr[], int idx, int n)
    {
        if(idx>=n){
            res.add(new ArrayList<Integer>(ans));
            return;
        }

        //skip
        sol(arr, idx+1, n);

        //take
        ans.add(arr[idx]);
        sol(arr, idx+1, n);

        ans.remove(ans.size()-1);
    }
}