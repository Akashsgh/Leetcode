class Solution {
    static long MOD = 1_000_000_007L;
    static int[] exp10;
    static {
        exp10 = new int[100001];
        exp10[0] = 1;
        for (int i = 1; i < 100001; i++) {
            exp10[i] = (int) ((exp10[i - 1] * 10L) % MOD);
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] ans = new int[queries.length];
        int[] prefixSum = new int[n];
        int[] prefixCon = new int[n];
        int[] prefixFreq = new int[n];

        int sum = 0;
        long Con = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int val = s.charAt(i) - '0';
            if (val != 0) {
                sum += val;
                Con = ((Con * 10) + val) % MOD;
                count++;
            }
            prefixSum[i] = sum;
            prefixCon[i] = (int) Con;
            prefixFreq[i] = count;
        }

        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            int countDiff = prefixFreq[R] - ((L == 0) ? 0 : prefixFreq[L - 1]);
            int currSum = prefixSum[R] - ((L == 0) ? 0 : prefixSum[L - 1]);

            if (currSum == 0) {
                ans[i] = 0;
                continue;
            }

            long val = ((prefixCon[R] - (int) ((((L == 0) ? 0 : prefixCon[L - 1]) * 1L * exp10[countDiff]) % MOD)) + MOD) % MOD;
            ans[i] = (int) ((1L * val * currSum) % MOD);
        }
        return ans;
    }
}