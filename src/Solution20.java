import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>() {
            {
                put(']', '[');
                put(')', '(');
                put('}', '{');
            }
        };
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.empty() || stack.peek() != map.get(c)) return false;
                else stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}