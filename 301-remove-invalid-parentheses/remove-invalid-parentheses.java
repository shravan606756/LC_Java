class Solution {
    List<String> res = new ArrayList<>();
    int n;
    public List<String> removeInvalidParentheses(String s) {
        n = s.length();

        solve(s, 0, 0, "");

        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int i=0 ; i<res.size() ; i++){
            String temp = res.get(i);

            if(set.contains(temp)){
                continue;
            }

            set.add(temp);
            ans.add(temp);
        }

        int maxLength = -1;

        for(int i=0 ; i<ans.size();  i++){
            String curr = ans.get(i);
            int currLength = curr.length();

            maxLength = Math.max(maxLength, currLength);
        }

        /*for(int i=0 ; i<ans.size() ; i++){
            String curr = ans.get(i);

            if(curr.length() != maxLength){              
                ans.remove(curr);
            }
        }*/ 

        /* important bug : skipping and moving forward causing idx skipping
        reason : dynamic size change in ArrayList of ans */

        for(int i=ans.size()-1 ; i>=0 ; i--){
            String curr = ans.get(i);

            if(curr.length() != maxLength){              
                ans.remove(i);
            }
        }

        return ans;
    }

    public void solve(String s, int idx, int count, String temp)
    {
        if(count<0){
            return;
        }

        if(idx==n){
            if(count==0){
                res.add(new String(temp));
                return;
            }

            return;
        }

        if(s.charAt(idx)!='(' && s.charAt(idx)!=')'){
            //temp += s.charAt(idx);
            solve(s, idx+1, count, temp + s.charAt(idx));
           // temp -= s.charAt(idx);  //important bug *String is immut so explicit B.T isnt req*
           return;
        }

        //temp += s.charAt(idx);
        solve(s, idx+1, count+ (s.charAt(idx)==')' ? -1 : 1), temp + s.charAt(idx));
        //temp -= s.charAt(idx);

        solve(s, idx+1, count, temp);
    }
}