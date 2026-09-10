static class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

static class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        
        TrieNode curr = root;
        for(Character ch : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        curr.isEnd = true;
    }
}


class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();

        for(String word : dictionary) {
            trie.addWord(word);
        }
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        
        return dfs(0, s, trie, dp);
    }

    private int dfs(int i, String s, Trie trie, int[] dp) {
        if(i == s.length()) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int res = 1 + dfs(i + 1, s, trie, dp);
        TrieNode curr = trie.root;
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (!curr.children.containsKey(c)) break;
            curr = curr.children.get(c);
            if (curr.isEnd) {
                res = Math.min(res, dfs(j + 1, s, trie, dp));
            }
        }
        dp[i] = res;
        return res;
    }
}