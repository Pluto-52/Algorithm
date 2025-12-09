package Tree.node;

import java.util.Random;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 生成一个指定节点数的随机二叉树
     * @param nodeCount 节点数量
     * @return 树的根节点
     */
    public static TreeNode generateRandomTree(int nodeCount) {
        if (nodeCount <= 0) return null;

        Random random = new Random();
        TreeNode root = new TreeNode(random.nextInt(100));
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int count = 1;

        while (count < nodeCount && !queue.isEmpty()) {
            TreeNode current = queue.poll();

            // 添加左子节点
            if (count < nodeCount) {
                current.left = new TreeNode(random.nextInt(100));
                queue.offer(current.left);
                count++;
            }

            // 添加右子节点
            if (count < nodeCount) {
                current.right = new TreeNode(random.nextInt(100));
                queue.offer(current.right);
                count++;
            }
        }

        return root;
    }

    /**
     * 打印树结构，包含箭头指示
     * @param root 树的根节点
     */
    public static void printTree(TreeNode root) {
        printTreeHelper(root, "", true);
    }

    private static void printTreeHelper(TreeNode node, String prefix, boolean isLast) {
        if (node != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);

            if (node.left != null || node.right != null) {
                if (node.left != null) {
                    printTreeHelper(node.left, prefix + (isLast ? "    " : "│   "), node.right == null);
                }
                if (node.right != null) {
                    printTreeHelper(node.right, prefix + (isLast ? "    " : "│   "), true);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 生成一个包含10个节点的随机树并打印
        TreeNode root = TreeNode.generateRandomTree(10);
        TreeNode.printTree(root);

    }
}
