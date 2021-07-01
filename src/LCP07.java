public class LCP07 {
}

//class Solution {
//    public int numWays(int n, int[][] relation, int k) {
//        int[][] f = new int[k + 1][n];
//        f[0][0] = 1;
//        for (int i = 0; i < k; i++) {
//            for (int[] r : relation) {
//                int src = r[0], dst = r[1];
//                f[i + 1][dst] += f[i][src];
//            }
//        }
//        return f[k][n - 1];
//    }
//}

class Solution {
    public int numWays(int n, int[][] relation, int k) {
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] tmp = new int[n];
            for (int[] r : relation) {
                int src = r[0], dst = r[1];
                tmp[dst] += f[src];
            }
            f = tmp;
        }
        return f[n - 1];
    }
}