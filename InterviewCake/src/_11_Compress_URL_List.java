import java.util.HashMap;

class _11_Compress_URL_List {
    class TrieNode {
        private HashMap<Character, TrieNode> nodeChildren;

        TrieNode() {
            this.nodeChildren = new HashMap<>();
        }

        public boolean hasChildNode(char character) {
            return this.nodeChildren.containsKey(character);
        }

        public void makeChildNode(char character) {
            this.nodeChildren.put(character, new TrieNode());
        }

        public TrieNode getChildNode(char character) {
            return this.nodeChildren.get(character);
        }
    }

    public class Trie {
        private TrieNode rootNode;
        private final char endOfWordMarker = '\0';

        public Trie() {
            this.rootNode = new TrieNode();
        }

        public boolean addWord(String word) {
            TrieNode currentNode = this.rootNode;
            boolean isNewWord = false;

            // Work downwards through the trie, adding nodes
            // as needed, and keeping track of whether we add
            // any nodes.
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);

                if (!currentNode.hasChildNode(character)) {
                    isNewWord = true;
                    currentNode.makeChildNode(character);
                }

                currentNode = currentNode.getChildNode(character);
            }

            // Explicitly mark the end of a word.
            // Otherwise, we might say a word is
            // present if it is a prefix of a different,
            // longer word that was added earlier.
            if (!currentNode.hasChildNode(endOfWordMarker)) {
                isNewWord = true;
                currentNode.makeChildNode(endOfWordMarker);
            }

            return isNewWord;
        }
    }
}