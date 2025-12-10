package Tree;

import Tree.node.TreeNode;

import java.util.Stack;

public class IncreasingBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBalancedBST(10);
        System.out.println("原始BST：");
        TreeNode.printTree(root);
        TreeNode increasingRoot = increasingBST(root);
        System.out.println("递增顺序树：");
        TreeNode.printTree(increasingRoot);
    }

    private static TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current=root;
        TreeNode pre=null;
        TreeNode first=null;
        while(current!=null|!stack.isEmpty()) {
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
            current=stack.pop();
            if(pre!=null){
                pre.right=current;
            }else{
                first=current;
            }
            pre=current;
            current.left=null;
            current=current.right;
        }
        return first;
    }

}
