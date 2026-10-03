class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open=0;

        for(int i=0 ; i<s.length()-1  ; i++){
            if(s.charAt(i)=='('){
                if(open>0){
                    sb.append(s.charAt(i));
                }
                open++;
            }
            
            if(s.charAt(i)==')'){
                open--;
                if(open>0){
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}