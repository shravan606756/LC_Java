class Solution {
    public int minOperations(String s) 
    {
        char firstChar = s.charAt(0);
        int n = s.length();

        int count1= 0;
        int count2 = 0;

        for(int i=0 ; i<n ; i++)
        {
            char x = s.charAt(i);
            if(firstChar =='1')
            {
                if(i%2==0)
                {
                    if(x!='1')
                    {
                        count1++;
                    }

                    if(x!='0')
                    {
                        count2++;
                    }                    
                }

                else
                {
                    if(x!='0')
                    {
                        count1++;
                    }

                    if(x!='1')
                    {
                        count2++;
                    }
                }
            }

            if(firstChar =='0')
            {
                if(i%2==0)
                {
                    if(x!='0')
                    {
                        count1++;
                    }

                    if(x!='1')
                    {
                        count2++;
                    }
                }

                else
                {
                    if(x!='1')
                    {
                        count1++;
                    }

                    if(x!='0')
                    {
                        count2++;
                    }
                }
            }
        }

        return Math.min(count1,count2);
    }
}