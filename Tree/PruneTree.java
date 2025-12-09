package Tree;

import Tree.node.TreeNode;

public class PruneTree {
    public static void main(String[] args) {
        TreeNode root = generateTree(10);
        System.out.println("原始树：");
        TreeNode.printTree(root);
        TreeNode prunedRoot = pruneTree(root);
        System.out.println("修剪后的树：");
        TreeNode.printTree(prunedRoot);
    }
    public static TreeNode pruneTree(TreeNode root) {
       if(root==null)return null;
       root.left=pruneTree(root.left);
       root.right=pruneTree(root.right);
       if(root.val==0&&root.left==null&&root.right==null){
           return null;
       }
       return root;
    }
    public static TreeNode generateTree(int n){
        if (n <= 0) return null;

        // 创建根节点，值为0或1
        TreeNode root = new TreeNode((int)(Math.random() * 2));

        // 使用队列进行层序遍历构建树
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        int count = 1;
        while (count < n && !queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 随机生成左子节点
            if (count < n) {
                node.left = new TreeNode((int)(Math.random() * 2));
                queue.offer(node.left);
                count++;
            }

            // 随机生成右子节点
            if (count < n) {
                node.right = new TreeNode((int)(Math.random() * 2));
                queue.offer(node.right);
                count++;
            }
        }

        return root;
    }

}
