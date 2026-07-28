import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) 
    {
        int n = s.length();
        char arr[] = s.toCharArray();
        int mid = n / 2;

        Arrays.sort(arr, 0, mid);

        StringBuilder firstHalf = new StringBuilder();
        for (int i = 0; i < mid; i++)
        {
            firstHalf.append(arr[i]);
        }

        StringBuilder secondHalf = new StringBuilder();
        for (int i = mid - 1; i >= 0; i--)
        {
            secondHalf.append(arr[i]);
        }

        if (n % 2 == 0)
        {
            return firstHalf.toString() + secondHalf.toString();
        }

        return firstHalf.toString() + s.charAt(mid) + secondHalf.toString();
    }
}