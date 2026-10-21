class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (isSorted(s)) return 0;
        if (n == 2) return -1;

        char min = s.charAt(0), max = s.charAt(0);
        for (int i = 1; i < n; i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        if (s.charAt(0) == min || s.charAt(n - 1) == max) return 1;

        char mn = s.charAt(1), mx = s.charAt(1);
        for (int i = 2; i < n - 1; i++) {
            mn = (char) Math.min(mn, s.charAt(i));
            mx = (char) Math.max(mx, s.charAt(i));
        }

        if (s.charAt(0) > mx && s.charAt(n - 1) < mn) return 3;
        return 2;
    }

    public boolean isSorted(String s) {
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i - 1) > s.charAt(i)) return false;
        return true;
    }
}