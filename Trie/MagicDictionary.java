package Trie;
import Trie.Trie.TrieNode;

public class MagicDictionary {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        TrieNode root = magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search(root,"hello")); // 返回 false
        System.out.println(magicDictionary.search(root,"hhllo")); // 返回 true
        System.out.println(magicDictionary.search(root,"hell"));  // 返回 false
        System.out.println(magicDictionary.search(root,"leetcoded")); // 返回 false
    }
    public static TrieNode buildDict(String[] dictionary) {
        TrieNode root=new TrieNode();
        for (String s : dictionary) {
            TrieNode node=root;
            for (char c : s.toCharArray()) {
                if(node.children[c-'a']==null){
                    node.children[c-'a']=new TrieNode();
                }
                node=node.children[c-'a'];
            }
            node.isWord=true;
        }
        return root;
    }
    public static boolean search(TrieNode root, String searchWord) {
        return dfs(root,searchWord,0,0);
    }
    private static boolean dfs(TrieNode node, String word, int i, int edit){
        if(node==null){
            return false;
        }
        if(node.isWord&&i==word.length()&&edit==1){
            return true;
        }
        if(i<word.length()&&edit<=1){
            boolean found=false;
            for(int j=0;j<26&&!found;j++){
                int next=j==word.charAt(i)-'a'?edit:edit+1;
                found=dfs(node.children[j],word,i+1,next);
            }
            return found;
        }
        return false;
    }
}
