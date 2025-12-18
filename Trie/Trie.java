package Trie;

public class Trie {
    static class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children=new TrieNode[26];
            isWord=false;
        }
    }
    private TrieNode root;
    public Trie(){
        root=new TrieNode();
    }

    public void insert(String words){
        TrieNode node=root;
        for (char word : words.toCharArray()) {
            if(node.children[word-'a']==null){
                node.children[word-'a']=new TrieNode();
            }
            node=node.children[word-'a'];
        }
        node.isWord=true;
    }

    public boolean search(String words){
        TrieNode node=root;
        for (char word : words.toCharArray()) {
            if(node.children[word-'a']==null){
                return false;
            }
            node=node.children[word-'a'];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix){
        TrieNode node=root;
        for (char ch : prefix.toCharArray()) {
            if(node.children[ch-'a']==null){
                return false;
            }
            node=node.children[ch-'a'];
        }
        return true;
    }
}
