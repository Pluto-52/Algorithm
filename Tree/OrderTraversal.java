package Tree;
import Tree.node.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class OrderTraversal {
    public static List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> nodes=new LinkedList<>();
        dfs1(root,nodes);
        return nodes;
    }

    public static List<Integer> inOrderTraversal2(TreeNode root){
        List<Integer> nodes=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while(current!=null||!stack.isEmpty()){
            while (current!=null) {
                stack.push(current);
                current=current.left;
            }
            TreeNode node = stack.pop();
            nodes.add(node.val);
            current=node.right;
        }
        return nodes;
    }
    public static List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> nodes=new LinkedList<>();
        dfs2(root,nodes);
        return nodes;
    }

    public static List<Integer> preOrderTraversal2(TreeNode root){
        List<Integer> nodes=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while(current!=null||!stack.isEmpty()){
            while(current!=null){
                nodes.add(current.val);
                stack.push(current);
                current=current.left;
            }
            TreeNode node=stack.pop();
            current=node.right;
        }
        return nodes;
    }

    public static List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> nodes=new LinkedList<>();
        dfs3(root,nodes);
        return nodes;
    }

    public static List<Integer> postOrderTraversal2(TreeNode root){
        List<Integer> nodes=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        TreeNode pre=null;
        while(current!=null||!stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.peek();
            if (current.right!=null&&current.right!=pre){
                current=current.right;
            }else{
                stack.pop();
                nodes.add(current.val);
                pre=current;
                current=null;
            }
        }
        return nodes;
    }
    public static void dfs1(TreeNode root, List<Integer> nodes){
        if(root!=null){
            dfs1(root.left,nodes);
            nodes.add(root.val);
            dfs1(root.right,nodes);
        }
    }
    public static void dfs2(TreeNode root, List<Integer> nodes){
        if(root!=null){
            nodes.add(root.val);
            dfs2(root.left,nodes);
            dfs2(root.right,nodes);
        }
    }
    public static void dfs3(TreeNode root, List<Integer> nodes){
        if(root!=null){
            dfs3(root.left,nodes);
            dfs3(root.right,nodes);
            nodes.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateRandomTree(10);
        TreeNode.printTree(root);
        System.out.println("中序遍历"+inOrderTraversal(root));
        System.out.println(inOrderTraversal2(root));
        System.out.println("先序遍历"+preOrderTraversal(root));
        System.out.println(preOrderTraversal2(root));
        System.out.println("后序遍历"+postOrderTraversal(root));
        System.out.println(postOrderTraversal2(root));
    }
}
