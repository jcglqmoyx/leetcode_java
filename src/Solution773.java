import java.util.*;

public class Solution773 {
    private boolean equal(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void swap(int[][] arr, int a, int b, int c, int d) {
        int temp = arr[a][b];
        arr[a][b] = arr[c][d];
        arr[c][d] = temp;
    }

    private String getStatus(int[][] a) {
        StringBuilder builder = new StringBuilder();
        for (int[] row : a) {
            for (int i : row) {
                builder.append(i);
            }
        }
        return builder.toString();
    }

    public int slidingPuzzle(int[][] board) {
        int[][] target = {{1, 2, 3}, {4, 5, 0}};
        if (equal(board, target)) return 0;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        Map<int[][], Integer> dist = new HashMap<>();
        dist.put(board, 0);
        Set<String> set = new HashSet<>();
        set.add(getStatus(board));
        Queue<int[][]> q = new LinkedList<>();
        q.offer(board);
        while (!q.isEmpty()) {
            int[][] t = q.poll();
            int x = 0, y = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (t[i][j] == 0) {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a < 0 || a == 2 || b < 0 || b == 3) continue;
                int[][] r = new int[2][3];
                for (int row = 0; row < r.length; row++) {
                    System.arraycopy(t[row], 0, r[row], 0, r[row].length);
                }
                swap(r, x, y, a, b);
                String status = getStatus(r);
                if (!set.contains(status)) {
                    dist.put(r, dist.get(t) + 1);
                    set.add(status);
                    if (equal(r, target)) return dist.get(r);
                    q.offer(r);
                }
            }
        }
        return -1;
    }
}