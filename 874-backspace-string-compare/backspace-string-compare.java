class Solution {
    public boolean backspaceCompare(String s, String t) {
        String NewS = build(s);
        String NewT = build(t);

        return NewS.equals(NewT);
    }

    public static String build(String s)
    {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<n ; i++)
        {
            char x = s.charAt(i);

            if(st.isEmpty()){
                if(x=='#'){
                    continue;
                }

                st.push(x);
                continue;
            }

            if(x=='#'){
                st.pop();
                continue;
            }

            st.push(x);
        }

        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
} 