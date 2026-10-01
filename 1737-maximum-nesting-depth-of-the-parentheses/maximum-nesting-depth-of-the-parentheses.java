class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();
        int max = Integer.MIN_VALUE;

        for(int i=0 ; i<n ; i++)
        {
            char c = s.charAt(i);

            if(c!=')' && c!='('){
                continue;
            }

            if(c=='('){
                st.push(c);
                max = Math.max(max, st.size());
            }else{
                st.pop();
            }
        }

        return max==Integer.MIN_VALUE ? 0 : max;
    }
}