class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        int score = 0;

        for(int i=0 ; i<n ; i++)
        {
            char c = s.charAt(i);

            if(c=='('){
                st.push(score);
                score=0;
            }else{
                if(s.charAt(i-1)=='('){
                    score = st.peek()+1;
                }else{
                    score = st.peek()+ score*2;
                }

                st.pop();
            }
        }

        return score;
    }
}