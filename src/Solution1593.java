import java.util.HashSet;
import java.util.Set;

class Solution1593 {
    int n;
    Set<String> set;
    int res;

    public int maxUniqueSplit(String s) {
        n = s.length();
        set = new HashSet<>();
        res = 0;
        dfs(s, 0);
        return res;
    }

    void dfs(String s, int idx) {
        if (idx == n) {
            res = Math.max(res, set.size());
            return;
        }
        for (int len = 1; idx + len <= n; len++) {
            String str = s.substring(idx, idx + len);
            if (set.contains(str)) continue;
            set.add(str);
            dfs(s, idx + len);
            set.remove(str);
        }
    }
}