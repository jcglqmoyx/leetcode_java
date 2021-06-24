public class Solution14 {
    static class Trie {
        boolean isEnd;
        Trie[] next;

        Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        void insert(String s) {
            Trie trie = this;
            for (char c : s.toCharArray()) {
                if (trie.next[c - 'a'] == null) {
                    trie.next[c - 'a'] = new Trie();
                }
                trie = trie.next[c - 'a'];
            }
            trie.isEnd = true;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        String str = strs[0];
        for (String s : strs) {
            if (s.length() < str.length()) str = s;
            trie.insert(s);
        }
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (trie.next[c - 'a'] != null && c != str.charAt(i)) {
                    return str.substring(0, len);
                }
            }
            len++;
            if (trie.next[str.charAt(i) - 'a'].isEnd) return str.substring(0, len);
            trie = trie.next[str.charAt(i) - 'a'];
        }
        return "";
    }
}