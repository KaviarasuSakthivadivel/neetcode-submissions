static class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}
class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(Character ch : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String w) {
        TrieNode curr = root;
        for(Character ch : w.toCharArray()) {
            curr = curr.children.get(ch);
            if(curr == null) {
                return null;
            }
        }
        return curr;
    }
}
