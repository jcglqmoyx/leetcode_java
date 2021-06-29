import java.util.*;

public class Solution815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        int[] dist = new int[n];
        Arrays.fill(dist, 1000000000);
        Map<Integer, Set<Integer>> g = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int x : routes[i]) {
                if (x == source) {
                    dist[i] = 1;
                    q.offer(i);
                }
                if (!g.containsKey(x)) {
                    g.put(x, new HashSet<>());
                }
                g.get(x).add(i);
            }
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int x : routes[t]) {
                if (x == target) return dist[t];
                if (g.containsKey(x)) {
                    for (int y : g.get(x)) {
                        if (dist[y] > dist[t] + 1) {
                            dist[y] = dist[t] + 1;
                            q.offer(y);
                        }
                    }
                }
                g.remove(x);
            }
        }
        return -1;
    }
}