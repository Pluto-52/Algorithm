package Tree;

import Tree.node.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FindTarget {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBalancedBST(10);
        System.out.println("原始BST：");
        TreeNode.printTree(root);
        int k = 9;
        boolean found = findTarget3(root, k);
        System.out.println("是否存在两个节点之和为 " + k + " : " + found);
    }
    public static boolean findTarget(TreeNode root, int k) {
        boolean[] found={false};
        Set<Integer> set=new HashSet<>();
        dfs(root,k,found,set);
        return found[0];
    }
    private static TreeNode dfs(TreeNode root,int k,boolean[] found,Set<Integer> set){
        if(root==null)return null;
        dfs(root.left,k,found,set);
        dfs(root.right,k,found,set);
        if(set.contains(k-root.val)){
            found[0]=true;
        }
        set.add(root.val);
        return root;
    }

    public static boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(set.contains(k-cur.val)){
                return true;
            }
            set.add(cur.val);
            cur=cur.right;
        }
        return false;
    }

    public static boolean findTarget3(TreeNode root, int k) {
        LeftIterator leftIterator = new LeftIterator(root);
        RightIterator rightIterator = new RightIterator(root);
        int left = leftIterator.next();
        int right = rightIterator.next();
        while(left<right){
            if(right+left==k){
                return true;
            }else if(left+right<k){
                left=leftIterator.next();
            }
            else{
                right=rightIterator.next();
            }
        }
        return false;
    }

    public static class LeftIterator {
        private Stack<TreeNode> stack;
        private TreeNode cur;

        public LeftIterator(TreeNode root) {
            this.stack = new Stack<>();
            this.cur=root;
        }

        public boolean hasNext() {
            return cur!=null||!stack.isEmpty();
        }

        public int next() {
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            int val=cur.val;
            cur=cur.right;
            return val;
        }

    }

    public static class RightIterator {
        private Stack<TreeNode> stack;
        private TreeNode cur;

        public RightIterator(TreeNode root) {
            this.stack = new Stack<>();
            this.cur=root;
        }

        public boolean hasNext() {
            return cur!=null||!stack.isEmpty();
        }

        public int next() {
            while(cur!=null){
                stack.push(cur);
                cur=cur.right;
            }
            cur=stack.pop();
            int val=cur.val;
            cur=cur.left;
            return val;
        }

    }

}
