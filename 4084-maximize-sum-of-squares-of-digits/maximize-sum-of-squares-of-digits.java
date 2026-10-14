class Solution {
    public String maxSumOfSquares(int num, int sum) {
        /*
        int count=0;
        int maxScore = 0;
        int max = 0;

        while(true){
            String s = String.valueOf(count);
            int len = s.length();
            int currScore = 0;

            if(len>num){
                break;
            }

            if(len==num && isValid(count, num, sum)){
                currScore = computeScore(count);
                
                if(currScore>=maxScore){
                    maxScore = currScore;
                    max = count;
                }
            }

            count++;
        }

        return max == 0 ? "" : String.valueOf(max);
        */
        
        if(sum > num*9){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int nine = sum/9;
        int rem = sum%9;
        for(int i=0 ; i<nine ; i++){
            sb.append("9");
        }

        if (rem > 0) sb.append(rem);
        
        while (sb.length() < num) {
            sb.append("0");
        }

        return sb.toString();
    }

    /*public static boolean isValid(int x, int n, int sum){
        int currSum=0;
            while(x>0){
            int temp = x%10;
            currSum += temp;
            x /= 10;
        }

        return currSum == sum;
    }

    public static int computeScore(int x)
    {
        int sum=0;
        while(x>0){
            int temp = x%10;
            sum += temp*temp;
            x /= 10;
        }

        return sum;
    }*/
}