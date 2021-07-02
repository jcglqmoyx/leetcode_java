import java.util.Arrays;
import java.util.Comparator;

public class Solution451 {
    public String frequencySort(String s) {
        int[] cnt = new int[128];
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < chars.length; i++) chars[i] = s.charAt(i);
        for (char c : chars) cnt[c]++;
        Arrays.sort(chars, new Comparator<>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (cnt[o2] != cnt[o1]) return cnt[o2] - cnt[o1];
                else return o2 - o1;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (char c : chars) builder.append(c);
        return builder.toString();
    }
}