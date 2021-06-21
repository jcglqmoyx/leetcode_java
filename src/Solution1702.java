import java.util.Arrays;

class Solution1702 {
    public String maximumBinaryString(String binary) {
        int k = 0, n = binary.length();
        while (k < n && binary.charAt(k) == '1') k++;
        if (k == n) return binary;
        int cnt = 0;
        for (int i = k + 1; i < n; i++) if (binary.charAt(i) == '0') cnt++;
        char[] chars = new char[n];
        Arrays.fill(chars, '1');
        chars[k + cnt] = '0';
        return new String(chars);
    }
}