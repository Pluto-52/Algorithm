package Trie;

public class MapSum {
    private  TrieNode root;

    private class TrieNode{
        TrieNode[] children;
        int value;
        boolean isWord;
        public TrieNode(){
            this.children=new TrieNode[26];
            this.value=0;
            this.isWord=false;
        }
    }
    public MapSum(){
        this.root=new TrieNode();
    }
    private  void insert(String word, int val){
        TrieNode node=this.root;
        for (char c : word.toCharArray()) {
            if(node.children[c-'a']==null){
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.isWord=true;
        node.value=val;
    }
    private  int sum(String prefix){
        TrieNode node=this.root;
        for (char c : prefix.toCharArray()) {
            if(node.children[c-'a']==null)return 0;
            node=node.children[c-'a'];
        }
//        int []sum={0};
//        dfs(node,sum);
//        return sum[0];
        return getSum(node);
    }
    public int getSum(TrieNode node){
        int result=0;
        for(TrieNode child:node.children){
            if(child!=null){
                if(child.isWord){
                    result+=child.value;
                }
                result+=getSum(child);
            }
        }
        return result;
    }
    public void dfs(TrieNode node,int[] sum){
        for(TrieNode child:node.children){
            if(child!=null){
                if(child.isWord){
                    sum[0]+=child.value;
                }
                dfs(child,sum);
            }
        }
    }
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap")); // 输出 3
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));// 输出 5
        mapSum.insert("apple", 2);
        System.out.println(mapSum.sum("ap"));// 输出 4
    }
}
