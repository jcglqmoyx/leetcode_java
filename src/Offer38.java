import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Offer38 {
    List<String> list;
    boolean[] used;
    StringBuilder builder;

    public String[] permutation(String s) {
        used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        builder = new StringBuilder();
        list = new ArrayList<>();
        dfs(chars, 0);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }

    void dfs(char[] chars, int index) {
        if (index == chars.length) {
            list.add(builder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || i > 0 && !used[i - 1] && chars[i] == chars[i - 1]) continue;
            used[i] = true;
            builder.append(chars[i]);
            dfs(chars, index + 1);
            builder.deleteCharAt(builder.length() - 1);
            used[i] = false;
        }
    }
}