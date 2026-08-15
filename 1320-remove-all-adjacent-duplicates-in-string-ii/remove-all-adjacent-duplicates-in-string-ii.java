class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<pair> st = new Stack<>();
        int n = s.length();

        for(int i=0 ; i<n ; i++)
        {
            char c = s.charAt(i);

            if(st.isEmpty()){
                st.push(new pair(c, 1));
                continue;
            }

            if(!st.isEmpty() && st.peek().c!=c){
                st.push(new pair(c, 1));
                continue;
            }

            if(!st.isEmpty() && st.peek().c==c && st.peek().n<k-1){
                pair temp = st.pop();
                int newCount = temp.n+1;
                st.push(new pair(c, newCount));
                continue;
            }

            if(st.peek().c==c && st.peek().n==k-1) st.pop();
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            pair temp = st.pop();
            for(int i=0 ; i<temp.n ; i++)
                sb.insert(0, temp.c);
        }

        return sb.toString();
    }
}

class pair
{
    char c;
    int n;
    public pair(char c, int n){
        this.c=c;
        this.n=n;
    }
}