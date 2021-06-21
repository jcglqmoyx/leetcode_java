import java.util.HashMap;
import java.util.Map;

class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> hash = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += hash.get(s.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                if (hash.get(s.charAt(j)) < hash.get(s.charAt(i))) {
                    res -= 2 * hash.get(s.charAt(j));
                }
            }
        }
        return res;
    }
}