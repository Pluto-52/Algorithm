package LinkedList;
import LinkedList.listNode.MultilevelLinkedList;
import LinkedList.listNode.MultilevelLinkedList.Node;
public class Flatten {
    //在多级双向链表中，节点除了有两个指针分别指向前后两个节点，还有一个指针指向下一个子链表。
    public static void main(String[] args) {

        Node head = MultilevelLinkedList.createAndPrintMultilevelList();
        System.out.println("展品多级双向链表");
        Node res = flatten1(head);
        MultilevelLinkedList.printMultilevelList(res);

    }

    public static Node flatten1(Node head) {
        flatten2( head);
        return head;
    }
    public static Node flatten2(Node head) {
        Node cur=head;
        Node tail=null;
        while(cur.next!=null){
            Node next=cur.next;
            if(cur.child!=null){
                Node childTail = flatten2(cur.child);
                cur.next=cur.child;
                cur.child.prev=cur;
                cur.child=null;
                childTail.next=next;
                next.prev=childTail;
                cur=childTail;
            }
            else{
                tail=cur;
            }
            cur=cur.next;
        }
        return tail;
    }
}
