class Solution {
    public String minWindow(String s, String t) 
    {
        /*
        STEP 1 :IDENTIFY PATTERN --> SLIDING WINDOW
        STEP 2 :IDENTIFY WINDOW TYPE --> DYNAMIC
        STEP 3 :MAINTAIN 2 FREQ ARRAY SEPRATELY FOR BOTH S AND P
        STEP 4 :IF NOT VALID --> SHRINK
                I.E IF FREQ OF S WINDOW < FREQ P ELEMENTS
                ***REQUIRE >= FREQ FOR STORING ANS
        */
        int n1 = s.length();
        int n2 = t.length();
        int low = 0 ;
        int have [] = new int[128];
        int need [] = new int[128];
        int ans = Integer.MAX_VALUE;
        int bestStart=0;
        for(char x : t.toCharArray())
        {
            need[x]++;
        }

        for(int high=0 ; high<n1 ; high++)
        {
            char c = s.charAt(high);
            have[c]++;

            while(isValid(have,need))
            {
                int len = high-low+1;
                
                if(len<ans)
                {
                    ans=len;
                    bestStart=low;
                }
                have[s.charAt(low)]--;
                low++;
            }
        }
        if(ans==Integer.MAX_VALUE) return "";
        return s.substring(bestStart , bestStart+ans);
    }

    public static boolean isValid(int arr[] , int arr1[])
    {
        for(int i=0 ; i<128 ; i++)
        {
            if(arr[i]<arr1[i])
            {
                return false;
            }
        }
        return true;
    }
}