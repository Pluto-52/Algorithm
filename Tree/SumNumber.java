package Tree;

import Tree.node.TreeNode;

public class SumNumber {
    public static void main(String[] args) {
        int nodeCount = 10; // 节点数量
        TreeNode root = generateRandomDigitTree(nodeCount);
        System.out.println("生成的随机数字二叉树：");
        TreeNode.printTree(root);
        int sum = sumRootToLeafNumbers(root);
        System.out.println("从根到叶子节点形成的数字之和: " +
                sum);
    }

    /**
     * 计算从根到叶子节点形成的数字之和
     * @param root 根节点
     * @return 和
     */
    public static int sumRootToLeafNumbers(TreeNode root) {
        return dfs(root,0);
    }

    public static int dfs(TreeNode node,int currentNumber){
       if(node==null)return 0;
       int sum=currentNumber*10+node.val;
       if(node.left==null&&node.right==null){
           return sum;
       }
       return dfs(node.left,sum)+dfs(node.right,sum);
    }
    /**
     * 生成一个由0-9随机数字组成的二叉树
     * @param nodeCount 节点数量
     * @return TreeNode 根节点
     */
    public static TreeNode generateRandomDigitTree(int nodeCount) {
        if (nodeCount <= 0) {
            return null;
        }

        // 生成0-9之间的随机数作为根节点值
        int rootValue = (int) (Math.random() * 10);
        TreeNode root = new TreeNode(rootValue);

        // 递归生成左右子树
        // 随机分配剩余节点数量给左右子树
        int leftCount = (int) (Math.random() * (nodeCount - 1));
        int rightCount = nodeCount - 1 - leftCount;

        root.left = generateRandomDigitTree(leftCount);
        root.right = generateRandomDigitTree(rightCount);

        return root;
    }
}
