package Queue;

import Queue.Node.ThreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    ThreeNode root;
    Queue<ThreeNode> queue;
    public CBTInserter(ThreeNode root) {
        this.root = root;
        queue=new LinkedList<>();
        queue.offer(root);
    }
    public int insert(int v) {
        ThreeNode node=queue.peek();
        while(!queue.isEmpty()){
            if(node.left==null){
                node.left=new ThreeNode(v);
            }
            if(node.right==null){
                node.right=new ThreeNode(v);
                queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return node.val;
    }
    public ThreeNode get_root() {
        return root;
    }
}
