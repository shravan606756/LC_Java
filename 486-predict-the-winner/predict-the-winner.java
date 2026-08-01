class Solution {
    public boolean predictTheWinner(int[] arr)
    {
        int totalScore =0;

        for(int x : arr){
            totalScore+=x;
        }

        int player1 = solve(arr, 0, arr.length-1);
        int player2 = totalScore-player1;

        return player1>=player2;
    }

    public int solve(int arr[], int i, int j){
        if(i>j){
            return 0;
        }
        if(i==j){
            return arr[i];
        }

        int c1 = arr[i] + Math.min(solve(arr, i+2, j), solve(arr, i+1, j-1));
        int c2 = arr[j] + Math.min(solve(arr, i+1, j-1), solve(arr, i, j-2));

        return Math.max(c1, c2);
    }
}