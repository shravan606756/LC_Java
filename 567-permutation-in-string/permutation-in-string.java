class Solution 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1>n2) return false;

        int have[] = new int [128];
        int need[] = new int [128];

        for(char x : s1.toCharArray())
        {
            need[x]++;
        }

        int high=0;

        for(high = 0 ; high<n1 ; high++)
        {
            have[s2.charAt(high)]++;
        }
        if(isValid(have , need)) return true;
        int low=0;
        while(high<n2)
        {
            have[s2.charAt(low)]--;
            low++;

            

            have[s2.charAt(high)]++;
            high++;

            if(isValid(have , need)) return true;
        }   
        return false;    
    }

    public static boolean isValid(int arr[] , int arr1[])
    {
        for(int i=0 ; i<128 ; i++)
        {
            if(arr[i]!=arr1[i])
            {
                return false;
            }
        }
        return true;
    }
}