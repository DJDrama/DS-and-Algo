public class Trie {
    private static final int ALPHABET_SIZE = 26;
    TrieNode root;

    // O(n) time complexity
    void insert(String key) {
        TrieNode pCrawl = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    // O(n) time complexity
    boolean search(String key) {
        TrieNode pCrawl = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return pCrawl != null && pCrawl.isEndOfWord;
    }

    TrieNode remove(TrieNode root, String key, int i) {
        if (root == null)
            return null;
        if (i == key.length()) {
            if (root.isEndOfWord)
                root.isEndOfWord = false;
            if (isEmpty(root))
                root = null;
            return root;
        }
        int index = key.charAt(i) - 'a';
        root.children[index] = remove(root.children[index], key, i + 1);

        if (isEmpty(root) && !root.isEndOfWord) {
            root = null;
        }
        return root;
    }

    private boolean isEmpty(TrieNode root) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null)
                return false;
        }
        return true;
    }


    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
    }
}

class Main {
    public static void main(String[] args) {
        String[] keys = {"bad", "bat", "power", "powers", "cat", "cut"};

        Trie t = new Trie();
        t.root = new Trie.TrieNode();

        for (String key : keys)
            t.insert(key);

        t.root = t.remove(t.root, "cut", 0);

        if (t.search("cut"))
            System.out.println("cut Found");
        else
            System.out.println("cut Not Found");

        if (t.search("cat"))
            System.out.println("cat Found");
        else
            System.out.println("cat Not Found");
    }
}