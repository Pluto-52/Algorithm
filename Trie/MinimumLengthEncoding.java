package Trie;

public class MinimumLengthEncoding {
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words)); // 输出: 10
    }
    private static class TrieNode{
        TrieNode[] children;
        public TrieNode(){
            this.children= new TrieNode[26];
        }
    }
    public static int minimumLengthEncoding(String[] words) {
        TrieNode root=createTrie(words);
        int[] length={0};
        dfs(root,1,length);
        return length[0];
    }
    private static void dfs(TrieNode root, int depth, int[] length) {
       boolean isLeaf=true;
        for (TrieNode child : root.children) {
            if(child!=null){
                isLeaf=false;
                dfs(child,depth+1,length);
            }
        }
        if(isLeaf) {
            length[0] += depth;
        }
    }
    private static TrieNode createTrie(String[] words) {
        TrieNode root=new TrieNode();
        for (String word : words) {
           TrieNode node=root;
           for(int i=word.length()-1;i>=0;i--){
               if(node.children[word.charAt(i)-'a']==null){
                   node.children[word.charAt(i)-'a']=new TrieNode();
               }
               node=node.children[word.charAt(i)-'a'];
           }
        }
        return root;
    }
}
