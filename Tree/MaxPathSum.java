package Tree;

import Tree.node.TreeNode;
public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = generateRandomTreeWithNegative(10);
        System.out.println("生成的随机二叉树（包含负数）：");
        TreeNode.printTree(root);
        int maxSum = maxPathSum(root);
        System.out.println("二叉树中的最大路径和: " + maxSum);
    }
    public static int maxPathSum(TreeNode root) {
        int [] maxSum={Integer.MIN_VALUE};
        dfs(root,maxSum);
        return maxSum[0];
    }

    private static int dfs(TreeNode node, int[] maxSum) {
        if(node==null)return 0;
        int[]leftSum={Integer.MIN_VALUE};
        int left=Math.max(0,dfs(node.left,leftSum));
        int[] rightSum={Integer.MIN_VALUE};
        int right=dfs(node.right,rightSum);
        maxSum[0]=Math.max(left,right);
        maxSum[0]=Math.max(maxSum[0],node.val+left+right);
        return node.val+Math.max(left,right);
    }

    /**
     * 生成一个包含负数的随机二叉树
     * @param nodeCount 节点数量
     * @return TreeNode 根节点
     */
    public static TreeNode generateRandomTreeWithNegative(int nodeCount) {
        if (nodeCount <= 0) {
            return null;
        }

        // 生成-10到10之间的随机整数作为根节点值
        int rootValue = (int) (Math.random() * 21) - 10; // 范围：-10 到 10
        TreeNode root = new TreeNode(rootValue);

        // 随机分配剩余节点数量给左右子树
        int leftCount = (int) (Math.random() * (nodeCount - 1));
        int rightCount = nodeCount - 1 - leftCount;

        root.left = generateRandomTreeWithNegative(leftCount);
        root.right = generateRandomTreeWithNegative(rightCount);

        return root;
    }
}
