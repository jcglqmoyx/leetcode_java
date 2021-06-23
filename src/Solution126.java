import java.util.*;

public class Solution126 {
    String beginWord;
    Set<String> wordSet = new HashSet<>();
    Map<String, Integer> dist = new HashMap<>();
    List<String> path = new LinkedList<>();
    List<List<String>> paths = new LinkedList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        dist.put(beginWord, 0);
        wordSet.addAll(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while (!q.isEmpty()) {
            String t = q.poll();
            for (int i = 0; i < t.length(); i++) {
                char[] chars = t.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    char tmp = chars[i];
                    chars[i] = c;
                    String s = new String(chars);
                    chars[i] = tmp;
                    if (wordSet.contains(s) && !dist.containsKey(s)) {
                        dist.put(s, dist.get(t) + 1);
                        if (s.equals(endWord)) break;
                        q.offer(s);
                    }
                }
            }
        }
        System.out.println(dist.get(endWord));
        if (!dist.containsKey(endWord)) return paths;
        path.add(endWord);
        dfs(endWord);
        return paths;
    }

    void dfs(String t) {
        if (t.equals(beginWord)) {
            Collections.reverse(path);
            paths.add(new LinkedList<>(path));
            Collections.reverse(path);
            return;
        }
        for (int i = 0; i < t.length(); i++) {
            char[] chars = t.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                char tmp = chars[i];
                chars[i] = c;
                String s = new String(chars);
                chars[i] = tmp;
                if (dist.containsKey(s) && dist.get(s) + 1 == dist.get(t)) {
                    path.add(s);
                    dfs(s);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}