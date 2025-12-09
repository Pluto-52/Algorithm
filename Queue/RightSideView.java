package Queue;

import Queue.Node.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static void main(String[] args) {
        Tree.TreeNode root = Tree.createRandomTree(10, 100);
        Tree.printTreeStructure();
        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideView(Tree.TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null)return res;
        Queue<Tree.TreeNode> current = new LinkedList<>();
        Queue<Tree.TreeNode> next = new LinkedList<>();
        current.offer(root);
        while(!current.isEmpty()){
            Tree.TreeNode node = current.poll();
            if(node.left!=null){
                next.offer(node.left);
            }
            if(node.right!=null){
                next.offer(node.right);
            }
            if (current.isEmpty()) {
                res.add(node.val);
                current = next;
                next = new LinkedList<>();
            }
        }
        return res;
    }
}
