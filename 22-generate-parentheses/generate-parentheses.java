class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder s = new StringBuilder();

    public List<String> generateParenthesis(int n) 
    {
        build(n * 2);
        return res;
    }

    public void build(int left) 
    {
        if (left == 0) {
            if (isValid(s.toString()))
                res.add(s.toString());
            return;
        }

        s.append('(');
        build(left - 1);
        s.deleteCharAt(s.length() - 1);

        s.append(')');
        build(left - 1);
        s.deleteCharAt(s.length() - 1);
    }

    public boolean isValid(String s) 
    {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (st.isEmpty()) {
                st.push(c);
                continue;
            }

            if (st.peek() == '(' && c == ')') {
                st.pop();
                continue;
            }

            st.push(c);
        }

        return st.size() == 0;
    }
}