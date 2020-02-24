package wangzheng.trie_35;

public class Trie {

    TrieNode root = new TrieNode('/');

    public void insert(char[] text){
        TrieNode p = root;
        for (int i = 0;i<text.length;i++){
            int index = text[i] - 'a';
            if (p.children[index] == null){
                TrieNode trieNode = new TrieNode(text[i]);
                p.children[index] = trieNode;
            }
            p = p.children[index];
        }
        p.isEnddingChar = true;
    }

    public boolean find(char[] pattern){
        TrieNode p = root;
        for (int i = 0;i<pattern.length;i++){
            int index = pattern[i]-'a';
            if (p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if (p.isEnddingChar){
            return true;
        }
        return false;
    }

    static class TrieNode{
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEnddingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String text1 = "jiahongyuan";
        String text2 = "songruirui";
        trie.insert(text1.toCharArray());
        trie.insert(text2.toCharArray());
        System.out.println(trie.find(text1.toCharArray()));
        System.out.println(trie.find("songruirui".toCharArray()));
    }
}
