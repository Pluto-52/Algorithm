package Trie;
import Trie.Trie.TrieNode;
public class ReplaceWords {
    public static void main(String[] args) {
        String[] dictionary = {"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        String result = replaceWords(dictionary, sentence);
        System.out.println(result); // 输出: "the cat was rat by the bat"
    }
    public static String replaceWords(String[] dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        String[] words=sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String w=getWords(root,words[i]);
            if(w!=""){
                words[i]=w;
            }
        }
        return String.join(" ",words);
    }

    private static String getWords(TrieNode root, String word) {
        TrieNode node=root;
        StringBuilder prefix=new StringBuilder();
        for (char c : word.toCharArray()) {
            if(node.isWord||node.children[c-'a']==null){
                break;
            }
            prefix.append(c);
            node=node.children[c-'a'];
        }
        return node.isWord?prefix.toString():"";
    }

    private static TrieNode buildTrie(String[] dictionary) {
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
}
