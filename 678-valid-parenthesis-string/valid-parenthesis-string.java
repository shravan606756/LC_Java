class Solution {
    int n;
    int dp[][];

    public boolean checkValidString(String s) {
        n = s.length();
        /*boolean hasStar = false;
        boolean res     = false;
        
        if(s.contains("*")){
            hasStar=true;
        }else{
            hasStar=false;
        }

        String removedStar  = s.replace("*","");
        String leftParStar  = s.replace("*", "(");
        String rightParStar = s.replace("*", ")");

        if(hasStar==true && noStarValid(s)==true){
            res=true;
        }else{
            if(noStarValid(removedStar) || noStarValid(leftParStar) || noStarValid(rightParStar)){
                res=true;
            }
        }

        return res;*/

        dp = new int[n][n+1];

        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }

        return solve(s, 0, 0);
    }

    public boolean solve(String s, int idx, int count){
        if(count<0){
            return false;
        }
        if(idx==n){
            return count==0;
        }

        if(dp[idx][count]!=-1){
            return dp[idx][count]==1;
        }

        char c = s.charAt(idx);
        boolean ans;

        if(c=='('){
            ans = solve(s, idx+1, count+1);
        }else if(c==')'){
            ans = solve(s, idx+1, count-1);
        }else{
            ans = solve(s, idx+1, count+1) || solve(s, idx+1, count-1) || solve(s, idx+1, count);
        }

        dp[idx][count] = ans ? 1 : 0;

        return ans;
    }

    /*public boolean isValid(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0 ; i<s.length() ; i++)
        {
            char c = s.charAt(i);

            if(st.isEmpty()){
                st.push(c);
                continue;
            }

            if(st.peek()=='(' && c==')'){
                st.pop();
                continue;
            }

            st.push(c);
        }

        return st.size()==0 ? true : false;

        int count = 0;

        for(int i=0 ; i<s.length() ; i++)
        {
            char c = s.charAt(i);

            if(c=='('){
                count++;
            }else{
                count--;
            }

            if(count<0){
                return false;
            }
        }

        return count==0;
    }*/
}