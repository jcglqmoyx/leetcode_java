import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + costs[i - 1];
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (sum[mid] <= coins) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}