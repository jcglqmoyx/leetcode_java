import java.util.HashMap;
import java.util.Map;

public class Solution149 {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int[] p : points) {
            Map<Double, Integer> map = new HashMap<>();
            int ss = 0, vs = 0;
            for (int[] q : points) {
                if (p[0] == q[0] && p[1] == q[1]) ss++;
                else if (p[0] == q[0]) vs++;
                else {
                    double slope = (double) (p[1] - q[1]) / (p[0] - q[0]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            int cnt = vs;
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                cnt = Math.max(cnt, entry.getValue());
            }
            res = Math.max(res, cnt + ss);
        }
        return res;
    }
}
