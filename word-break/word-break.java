import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Build Trie
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEnd = true;
        }

        // Memoization map
        Map<Integer, Boolean> memo = new HashMap<>();

        // DFS function
        return dfs(0, s, root, memo);
    }

    private boolean dfs(int index, String s, TrieNode root, Map<Integer, Boolean> memo) {
        if (index == s.length()) return true; // reached end
        if (memo.containsKey(index)) return memo.get(index);

        TrieNode node = root;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.children.containsKey(c)) break; // no path in Trie
            node = node.children.get(c);
            if (node.isEnd) { // found a valid word
                if (dfs(i + 1, s, root, memo)) {
                    memo.put(index, true);
                    return true;
                }
            }
        }

        memo.put(index, false);
        return false;
    }
}
