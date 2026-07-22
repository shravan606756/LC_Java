class Solution {
    public int minSwaps(String s) 
    {
        int one=0;
        int zero=0;

        for(int i=0 ; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                one++;
            }else{
                zero++;
            }
        }

        if(Math.abs(zero-one)>1) return -1;
        
        if(zero>one){
            return countSwaps(s, '0');
        }
        if(one>zero){
            return countSwaps(s, '1');
        }

        return Math.min(countSwaps(s, '0'),countSwaps(s, '1'));
    }
    
    public int countSwaps(String s, char start){
        char expected = start;
        int notEqual=0;

        for(int i=0 ; i<s.length() ; i++)
        {
            if(s.charAt(i)!=expected){
                notEqual++;
            }

            expected = (expected=='0'? '1' : '0');
        }

        return notEqual/2;
    }
}