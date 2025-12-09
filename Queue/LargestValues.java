package Queue;

import Queue.Node.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {
    public static void main(String[] args) {
        Tree.TreeNode root = Tree.createRandomTree(10, 100);
        Tree.printTreeStructure();
        System.out.println(largestValues2(root));
    }
    public static List< Integer> largestValues(Tree.TreeNode root) {
        int count=0;
        int next=0;
        Queue<Tree.TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
            count=1;
        }
        List<Integer> res = new LinkedList<>();
        int max=Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Tree.TreeNode node = queue.poll();
            count--;
            max=Math.max(max,node.val);
            if(node.left != null){
                queue.offer(node.left);
                next++;
            }
            if(node.right != null){
                queue.offer(node.right);
                next++;
            }
            if(count==0){
                count=next;
                next=0;
                res.add(max);
                max=Integer.MIN_VALUE;
            }
        }
        return res;
    }
    public static List<Integer> largestValues2(Tree.TreeNode root) {
        Queue<Tree.TreeNode> current = new LinkedList<>();
        Queue<Tree.TreeNode> next = new LinkedList<>();
        if(root != null){
            current.offer(root);
        }
        List<Integer> res = new LinkedList<>();
        int max=Integer.MIN_VALUE;
        while (!current.isEmpty()) {
            Tree.TreeNode node = current.poll();
            max=Math.max(max,node.val);
            if(node.left!=null){
                next.offer(node.left);
            }
            if(node.right!=null){
                next.offer(node.right);
            }
            if (current.isEmpty()) {
                res.add(max);
                max=Integer.MIN_VALUE;
                current=next;
                next=new LinkedList<>();
            }
        }
        return res;
    }
}
