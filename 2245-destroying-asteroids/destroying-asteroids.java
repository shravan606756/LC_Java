class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currMass = mass;

        for (int x : asteroids) {
            if (currMass < x) {
                return false;
            }

            currMass += x;
        }

        return true;
    }
}