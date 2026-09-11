class Solution {
    public int totalNumbers(int[] arr) {
        int[] freq = new int[10];
        Set<Integer> set = new HashSet<>();

        for (int x : arr) {
            freq[x]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0) continue;

            freq[i]--;

            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0) continue;

                freq[j]--;

                for (int k = 0; k <= 8; k += 2) {
                    if (freq[k] == 0) continue;

                    int num = i * 100 + j * 10 + k;
                    set.add(num);
                }

                freq[j]++;
            }

            freq[i]++;
        }

        return set.size();
    }
}