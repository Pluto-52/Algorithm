package Tree;

import Tree.node.TreeNode;

import java.util.Stack;

public class converBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBalancedBST(10);
        System.out.println("原始BST：");
        TreeNode.printTree(root);
        TreeNode convertedRoot = convertBST2(root);
        System.out.println("转换后的Greater Tree：");
        TreeNode.printTree(convertedRoot);
    }
    private static TreeNode convertBST(TreeNode root) {
        int[] sum={0};
        dfs(root,sum);
        return root;
    }

    private static TreeNode convertBST2(TreeNode root) {
        int sum=0;
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.right;
            }
            cur=stack.pop();
            sum+=cur.val;
            cur.val=sum;
            cur=cur.left;
        }
        return root;
    }
    private static void dfs(TreeNode node,int[] sum){
        if(node==null)return;
        dfs(node.right,sum);
        sum[0]+=node.val;
        node.val=sum[0];
        dfs(node.left,sum);
    }
}
