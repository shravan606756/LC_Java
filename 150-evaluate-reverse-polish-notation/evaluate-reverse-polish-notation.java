class Solution {
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<tokens.length ; i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))
            {
                int b = st.peek();
                st.pop();
                int a = st.peek();
                st.pop();

                int res = Nigger(a, b, tokens[i]); 
                st.push(res);
            }

            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }    

        return st.peek();    
    }

    public int Nigger(int a, int b, String lulu){
        if(lulu.equals("+")){
            return a+b;
        }else if(lulu.equals("-")){
            return a-b;
        }else if(lulu.equals("*")){
            return a*b;
        }else{
            return a/b;
        }
    }
}