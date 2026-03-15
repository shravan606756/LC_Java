class Fancy {
    private final int MOD = (int)1e9 + 7;
    private List<Long> list;
    private long a, b;

    public Fancy() {
        list = new ArrayList<>();
        a = 1;
        b = 0;
    }

    private long mod_pow(long x, long y, long mod) {
        long res = 1;
        x %= mod;

        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % mod;
            }

            x = (x * x) % mod;
            y >>= 1;
        } 

        return res;
    }
    
    public void append(int val) {
        long inverse_mul = mod_pow(a, MOD - 2, MOD); 
        long saved = ((val - b + MOD) % MOD * inverse_mul) % MOD;
        list.add(saved);
    }
    
    public void addAll(int inc) {
        b = (b + inc) % MOD;
    }
    
    public void multAll(int m) {
        a = (a * m) % MOD;
        b = (b * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        return (int)((a * list.get(idx) + b) % MOD);
    }
}