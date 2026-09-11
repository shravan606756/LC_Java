class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0 ; i<digits.length ; i++)
        {
            for(int j=0; j <digits.length ; j++)
            {
                for(int k=0 ; k<digits.length ; k++)
                {
                    if (digits[i] == 0) {
                        continue;
                    }

                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    int num = (digits[i]*100) + (digits[j]*10) + (digits[k]*1);
                    if(num%2==0){
                        set.add(num);
                    }
                }
            }
        }

        return set.size();
    }
}