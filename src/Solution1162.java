import java.util.LinkedList;
import java.util.Queue;

class Solution1162 {
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        if (q.isEmpty() || q.size() == n * m) return -1;
        int res = 0;
        while (!q.isEmpty()) {
            boolean flag = false;
            for (int cnt = q.size(); cnt > 0; cnt--) {
                int[] t = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = t[0] + dx[i], y = t[1] + dy[i];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0) {
                        q.add(new int[]{x, y});
                        flag = true;
                        grid[x][y] = 1;
                    }
                }
            }
            if (flag) res++;
        }
        return res;
    }
}