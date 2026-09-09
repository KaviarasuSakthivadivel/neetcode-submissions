static class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(Character ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchInWord(word, root);
    }

    private boolean searchInWord(String word, TrieNode node) {
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)) {
                if(ch == '.') {
                    for(char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if(searchInWord(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(ch);
            }
        }

        return node.isEnd;
    }
}
