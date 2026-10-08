class Solution {
    public String addStrings(String num1, String num2) {        
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;

        int i = n1, j = n2, res=0, carry=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry>0){
            int x=0, y=0;

            if(i>=0){
                x = num1.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                y = num2.charAt(j)-'0';
                j--;
            }

            int sum = x+y+carry;
            sb.insert(0, sum%10);
            carry = sum/10;
        }

        return sb.toString();
    }

    /*public void convertToInt(String n1, String n2){
        int l1 = n1.length();
        int l2 = n2.length();

        for(int i=0 ; i<l1 ; i++)
        {
            int x = n1.charAt(i)-'0';
            num1 = num1*10 + x; 
        }

        for(int i=0 ; i<l2 ; i++)
        {
            int x = n2.charAt(i)-'0';
            num2 = num2*10 + x; 
        }
    }*/
}