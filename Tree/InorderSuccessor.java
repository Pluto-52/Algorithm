package Tree;

import Tree.node.TreeNode;

import java.util.Stack;

public class InorderSuccessor {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBalancedBST(10);
        System.out.println("原始BST：");
        TreeNode.printTree(root);
        System.out.println(inorderSuccessor2(root,5).val);
    }
    public static TreeNode inorderSuccessor(TreeNode root, int p) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        boolean found=false;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(found){
                return cur;
            }else if(cur.val==p){
                found=true;
            }
            cur=cur.right;
        }
        return cur;
    }

    private static TreeNode inorderSuccessor2(TreeNode root, int p) {
       TreeNode cur=root;
       TreeNode result=null;
       while(cur!=null){
           if(cur.val>p){
               result=cur;
               cur=cur.left;
           }
           else{
               cur=cur.right;
           }
       }
         return result;
    }
}
