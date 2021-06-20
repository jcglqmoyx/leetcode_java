class Solution1897 {
    public boolean makeEqual(String[] words) {
        int[] cnt = new int[26];
        for (String w : words) {
            for (char c : w.toCharArray()) {
                cnt[c - 'a']++;
            }
        }
        for (int x : cnt) if (x % words.length != 0) return false;
        return true;
    }
}