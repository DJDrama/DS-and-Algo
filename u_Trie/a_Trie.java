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
    boolean search(String key){
        TrieNode pCrawl = root;
        for(int level=0; level<key.length(); level++){
            int index = key.charAt(level)-'a';
            if(pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return pCrawl!=null && pCrawl.isEndOfWord;
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

        if (t.search("bad"))
            System.out.println("bad Found");
        else
            System.out.println("bad Not Found");

        if (t.search("powers"))
            System.out.println("powers Found");
        else
            System.out.println("powers Not Found");

        if (t.search("cu"))
            System.out.println("cu Found");
        else
            System.out.println("cu Not Found");
    }
}