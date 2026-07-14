import java.util.Arrays;

class Solution {

    int MOD = 1_000_000_007;
    int[][][] motaHatiyar;
    int[][] gcdTable;

    public int subsequencePairCount(int[] nums)
    {
        int n = nums.length;

        motaHatiyar = new int[n][201][201];

        for (int[][] roti : motaHatiyar)
        {
            for (int[] sabzi : roti)
            {
                Arrays.fill(sabzi, -1);
            }
        }

        gcdTable = new int[201][201];
        for (int i = 0; i <= 200; i++)
        {
            for (int j = 0; j <= 200; j++)
            {
                gcdTable[i][j] = gcd(i, j);
            }
        }

        return Tamatar(nums, 0, 0, 0);
    }

    public int Tamatar(int[] arr, int i, int seq1, int seq2)
    {
        if (i == arr.length) 
        {
            return (seq1 != 0 && seq1 == seq2) ? 1 : 0;
        }

        if (motaHatiyar[i][seq1][seq2] != -1)
        {
            return motaHatiyar[i][seq1][seq2];
        }

        long ans = 0;

        ans += Tamatar(arr, i + 1, seq1, seq2);

        ans += Tamatar(arr, i + 1, gcdTable[seq1][arr[i]], seq2);

        ans += Tamatar(arr, i + 1,seq1 , gcdTable[seq2][arr[i]]);

        return motaHatiyar[i][seq1][seq2] = (int) (ans % MOD);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}

/*
    (a,b) -> (b, a%b)  while b>0
    *** a>b
*/