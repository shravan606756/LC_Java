class Solution {
    int c=0;
    String r="";
    public String getHappyString(int n,int k){
        dfs(n,k,"");
        return r;
    }
    void dfs(int n,int k,String s){
        if(r.length()>0)return;
        if(s.length()==n){
            c++;
            if(c==k)r=s;
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if(s.length()>0 && s.charAt(s.length()-1)==ch)continue;
            dfs(n,k,s+ch);
        }
    }
}