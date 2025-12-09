package Queue.Node;

import java.util.Random;

public class Tree {

    // 二叉树节点类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode root;

    /**
     * 创建一个包含随机数值的二叉树
     *
     * @param nodeCount 节点数量
     * @param maxValue  最大值范围
     * @return
     */
    public static TreeNode createRandomTree(int nodeCount, int maxValue) {
        if (nodeCount <= 0) return null;

        Random random = new Random();
        root = new TreeNode(random.nextInt(maxValue));

        // 使用队列辅助构建二叉树
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < nodeCount; i++) {
            TreeNode current = queue.poll();

            // 添加左子节点
            current.left = new TreeNode(random.nextInt(maxValue));
            queue.offer(current.left);

            i++;
            if (i < nodeCount) {
                // 添加右子节点
                current.right = new TreeNode(random.nextInt(maxValue));
                queue.offer(current.right);
            }
        }
        return root;
    }

    /**
     * 打印二叉树（层序遍历）
     */
    public static void printTree() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        System.out.println("二叉树结构（层序遍历）:");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历打印
     */
    public void printInOrder() {
        System.out.print("中序遍历: ");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.val + " ");
            inOrderTraversal(node.right);
        }
    }

    /**
     * 以树形结构打印二叉树（使用箭头表示父子关系）
     */
    public static void  printTreeStructure() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        System.out.println("二叉树结构（树形显示）:");
        printTreeStructureHelper(root, "", true);
    }

    /**
     * 递归辅助方法，用于打印树形结构
     * @param node 当前节点
     * @param prefix 前缀字符串
     * @param isLast 是否为最后一个子节点
     */
    private static void printTreeStructureHelper(TreeNode node, String prefix, boolean isLast) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);

        // 计算子节点的前缀
        String childPrefix = prefix + (isLast ? "    " : "│   ");

        boolean hasLeft = (node.left != null);
        boolean hasRight = (node.right != null);

        if (hasLeft || hasRight) {
            if (hasLeft) {
                printTreeStructureHelper(node.left, childPrefix, !hasRight);
            }
            if (hasRight) {
                printTreeStructureHelper(node.right, childPrefix, true);
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.createRandomTree(10, 100); // 创建10个节点，值在0-99之间的随机树
        tree.printTree();               // 层序遍历打印
        tree.printInOrder();            // 中序遍历打印
        tree.printTreeStructure();      // 树形结构打印
    }
}
