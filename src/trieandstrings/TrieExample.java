package trieandstrings;

public class TrieExample {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("and");
        trie.insert("do");
        System.out.println(trie.search("dod"));
    }
}
class Trie {
    public static final int LETTERS = 26;
    public TrieNode root;
    public Trie() {
       root = new TrieNode();
    }
    public boolean search(String s) {
        int n = s.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++) {
            int curPos = s.charAt(i) - 'a';
            if(temp.children[curPos] == null) {
                return  false;
            }
            temp = temp.children[curPos];
        }
        return temp.isEnd;
    }
    public void insert(String s) {
        int n = s.length();
        TrieNode temp = root;
        for(int i=0;i<n;i++) {
            int curPos = s.charAt(i) - 'a';
            if(temp.children[curPos] == null) {
                temp.children[curPos] = new TrieNode();
            }
            temp = temp.children[curPos];
        }
        temp.isEnd = true;
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[LETTERS];
        boolean isEnd;
    }
}
