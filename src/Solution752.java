import java.util.*;

public class Solution752 {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target)) return 0;
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(start)) return -1;
        Map<String, Integer> dist = new HashMap<>();
        dist.put(start, 0);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            String t = q.poll();
            for (int i = 0; i < t.length(); i++) {
                for (int j = -1; j <= 1; j += 2) {
                    char[] chars = t.toCharArray();
                    chars[i] = (char) ((chars[i] - '0' + j + 10) % 10 + '0');
                    String s = new String(chars);
                    if (!dead.contains(s) && !dist.containsKey(s)) {
                        dist.put(s, dist.get(t) + 1);
                        if (s.equals(target)) return dist.get(s);
                        q.offer(s);
                    }
                }
            }
        }
        return -1;
    }
}