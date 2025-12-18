package Trie;

public class FindMaximunXOR {
    private TrieNode root;
    class TrieNode{
        TrieNode[] children;
        public TrieNode(){
            this.children=new TrieNode[2];
        }
    }
    public FindMaximunXOR(){
        this.root=new TrieNode();
    }
    private void createTrie(int[] nums){
        for (int num : nums) {
            TrieNode node=this.root;
            for(int i=31;i>=0;i--){
                int bit=num>>i&1;
                if(node.children[bit]==null){
                    node.children[bit]=new TrieNode();
                }
                node=node.children[bit];
            }
        }
    }
    private int getMaxXOR(int[] nums){
        int max=0;
        for (int num : nums) {
            TrieNode node=root;
            int xor=0;
            for(int i=31;i>=0;i--){
                int bit=num>>i&1;
                if(node.children[1-bit]!=null){
                    xor=(xor<<1)+1;
                    node=node.children[1-bit];
                }else{
                    xor=xor<<1;
                    node=node.children[bit];
                }
            }
            max=Math.max(max,xor);
        }
        return max;
    }
    private int findMaximumXOR(int[] nums) {
        createTrie(nums);
        return getMaxXOR(nums);
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(new FindMaximunXOR().findMaximumXOR(nums)); // 输出: 28
    }
}
