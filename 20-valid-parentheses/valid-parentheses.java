class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        
        for(int i=0 ; i<n ; i++)
        {
            char x = s.charAt(i);

            if(st.isEmpty()){
                st.push(x);
                continue;
            }
            if(st.peek()=='('&& x==')' || st.peek()=='{' && x=='}' || st.peek()=='[' && x==']'){
                st.pop();
                continue;
            }

            st.push(x);
        }

        return st.isEmpty();
    }
}