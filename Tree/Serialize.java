package Tree;

import Tree.node.TreeNode;

public class Serialize {
    public static void main(String[] args) {
        TreeNode root=TreeNode.generateRandomTree(10);
        System.out.println("原始树：");
        TreeNode.printTree(root);
        String serialized=serialize(root);
        System.out.println("序列化结果："+serialized);
        TreeNode deserialized=deserialize(serialized);
        System.out.println("反序列化后的树：");
        TreeNode.printTree(deserialized);
    }
    public static String serialize(TreeNode root){
        if(root==null)return "#";
        String left=serialize(root.left);
        String right=serialize(root.right);
        return root.val+","+left+","+right;
    }
    public static TreeNode deserialize(String data){
        String [] nodes=data.split(",");
        int[]i={0};
        return dfs(nodes,i);
    }
    public static TreeNode dfs(String[] nodes,int[] i){
        String str=nodes[i[0]];
        i[0]++;
        if(str.equals("#"))return null;
        TreeNode node=new TreeNode(Integer.parseInt(str));
        node.left=dfs(nodes,i);
        node.right=dfs(nodes,i);
        return node;
    }
}
