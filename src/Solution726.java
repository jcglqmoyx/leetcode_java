import java.util.Map;
import java.util.TreeMap;

public class Solution726 {
    int n, u;

    Map<String, Integer> dfs(String s) {
        Map<String, Integer> res = new TreeMap<>();
        while (u < n) {
            if (s.charAt(u) == '(') {
                u++;
                Map<String, Integer> t = dfs(s);
                u++;
                int k = u, cnt = 1;
                while (k < n && Character.isDigit(s.charAt(k))) k++;
                if (k > u) cnt = Integer.parseInt(s.substring(u, k));
                u = k;
                for (String str : t.keySet()) res.put(str, res.getOrDefault(str, 0) + cnt * t.get(str));
            } else if (s.charAt(u) == ')') break;
            else {
                int k = u + 1, cnt = 1;
                while (k < n && Character.isLowerCase(s.charAt(k))) k++;
                String key = s.substring(u, k);
                u = k;
                while (k < n && Character.isDigit(s.charAt(k))) k++;
                if (k > u) cnt = Integer.parseInt(s.substring(u, k));
                u = k;
                res.put(key, res.getOrDefault(key, 0) + cnt);
            }
        }
        return res;
    }

    public String countOfAtoms(String formula) {
        n = formula.length();
        u = 0;
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> t = dfs(formula);
        for (String key : t.keySet()) {
            builder.append(key);
            int cnt = t.get(key);
            if (cnt > 1) {
                builder.append(cnt);
            }
        }
        return builder.toString();
    }
}