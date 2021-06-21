import java.util.Arrays;

class Solution1824 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] f = new int[n][3];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], 10000000);
        f[0][0] = f[0][2] = 1;
        f[0][1] = 0;
        for (int i = 1; i < n; i++) {
            if (obstacles[i] != 1) f[i][0] = f[i - 1][0];
            if (obstacles[i] != 2) f[i][1] = f[i - 1][1];
            if (obstacles[i] != 3) f[i][2] = f[i - 1][2];
            if (obstacles[i] != 1) f[i][0] = Math.min(f[i][0], Math.min(f[i][1], f[i][2]) + 1);
            if (obstacles[i] != 2) f[i][1] = Math.min(f[i][1], Math.min(f[i][0], f[i][2]) + 1);
            if (obstacles[i] != 3) f[i][2] = Math.min(f[i][2], Math.min(f[i][0], f[i][1]) + 1);
        }
        return Math.min(f[n - 1][0], Math.min(f[n - 1][1], f[n - 1][2]));
    }
}