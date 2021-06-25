public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] ne = new int[needle.length()];
        ne[0] = -1;
        for (int i = 1, j = -1; i < ne.length; i++) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) j = ne[j];
            if (needle.charAt(i) == needle.charAt(j + 1)) j++;
            ne[i] = j;
        }
        for (int i = 0, j = -1; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) j = ne[j];
            if (haystack.charAt(i) == needle.charAt(j + 1)) j++;
            if (j == ne.length - 1) return i - j;
        }
        return -1;
    }
}