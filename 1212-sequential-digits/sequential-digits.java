class Solution {
    public List<Integer> sequentialDigits(int low, int high) 
    {
        List<Integer> res = new ArrayList<>();
        int curr = 12;

        while(curr<low){
            curr = getNextValid(curr);
        }

        while(curr<=high){
            res.add(curr);
            curr = getNextValid(curr);
        }

        return res;
    }

    public int getNextValid(int num)
    {
        if (num == 123456789) {
            return Integer.MAX_VALUE;
        }

        String s = String.valueOf(num);
        int n = s.length();

        if(s.charAt(n-1)!='9'){
            StringBuilder sb = new StringBuilder();

            for(char c : s.toCharArray()){
                sb.append((char)(c+1));
            }

            return Integer.parseInt(sb.toString());
        } 

        StringBuilder sb = new StringBuilder();        
        for(int i=1 ; i<=n+1 ; i++){
            sb.append((char) ('0'+i));
        }

        return Integer.parseInt(sb.toString());
    }
}