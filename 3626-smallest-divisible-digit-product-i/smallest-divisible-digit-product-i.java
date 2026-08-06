class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(!isValid(n, t)){
                n++;
            }else{
                break;
            }
        }

        return n;
    }

    public boolean isValid(int num, int k){
        int prod=1;
        while(num>0){
            int digit = num%10;
            prod *= digit;
            num /= 10;
        }

        return (prod%k==0) ? true : false;
    }
}