class Solution1872 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) pre[i] = pre[i - 1] + stones[i];
            else pre[i] = stones[i];
        }
        int[] f = new int[n];
        f[n - 1] = pre[n - 1];
        for (int i = n - 2; i > 0; i--) {
            f[i] = Math.max(f[i + 1], pre[i] - f[i + 1]);
        }
        return f[1];
    }
}