class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        String x = String.valueOf(n);

        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);

            if (c == '0') {
                continue;
            }

            sb.append(c);
        }

        if (sb.length() == 0) {
            return 0;
        }

        int num = Integer.parseInt(sb.toString());

        int sum = getSum(num);

        return (long) num * sum;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}