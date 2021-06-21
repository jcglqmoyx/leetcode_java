import java.util.ArrayList;
import java.util.List;

class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] tmp;
        int n = grid.length, m = grid[0].length;
        tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                index = (index + k) % (n * m);
                int r = index / m, c = index % m;
                tmp[r][c] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>(n);
        for (int[] row : tmp) {
            List<Integer> rowList = new ArrayList<>(m);
            for (int x : row) rowList.add(x);
            res.add(rowList);
        }
        return res;
    }
}