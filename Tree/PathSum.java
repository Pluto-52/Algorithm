package Tree;

import Tree.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = SumNumber.generateRandomDigitTree(10);
        System.out.println("生成的随机二叉树：");
        TreeNode.printTree(root);
        int targetSum = 15; // 目标和
        System.out.println("目标和: " + targetSum);
        int count = pathSum(root, targetSum);
        System.out.println("是否存在根到叶子节点的路径和等于目标和: " + count);
    }
    public static int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return dfs(root, targetSum,map,0);
    }

    private static int dfs(TreeNode root, int target, Map<Integer, Integer> map, int path) {
        if(root==null)return 0;
        path+=root.val;
        int count=map.getOrDefault(path-target,0);
        map.put(path,map.getOrDefault(path,0)+1);
        count+=dfs(root.left,target,map,path);
        count+=dfs(root.right,target,map,path);
        map.put(path,map.get(path)-1);
        return count;
    }

}
