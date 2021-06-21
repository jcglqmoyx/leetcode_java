class Solution1866 {
    public int rearrangeSticks(int n, int k) {
        final int MOD = (int) Math.pow(10, 9) + 7;
        int[][] f = new int[n + 1][k + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                f[i][j] = (int) ((f[i - 1][j - 1] + (long) (i - 1) * f[i - 1][j]) % MOD);
            }
        }
        return f[n][k];
    }
}