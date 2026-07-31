class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1;
        int high = max;
        int res = max;

        while (low <= high) {
            int guess = low + (high - low) / 2;

            long hours = getHour(piles, guess);

            if (hours > h) {
                low = guess + 1;
            } else {
                res = guess;
                high = guess - 1;
            }
        }

        return res;
    }

    public long getHour(int[] piles, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + (long) speed - 1) / speed;
        }

        return hours;
    }
}