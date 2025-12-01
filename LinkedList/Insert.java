package LinkedList;
import LinkedList.listNode.ListNode;

import java.util.Scanner;

public class Insert {

    public static void main(String[] args) {
        ListNode head = createAndPrintSortedCircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println("插入值"+k+"后");
        ListNode head1 = insert1(head, k);
        print(head1);
    }
    public static ListNode insert1(ListNode head, int val) {
        if (head==null){
            head = new ListNode(val);
            head.next=head;
        }
        else if(head.next==head){
            head.next =new ListNode(val);
            head.next.next=head;
        }else {
            ListNode cur = head;
            ListNode biggest=head;
            while(cur.next!=head&&!(cur.val<=val&&val<=cur.next.val)){
                if(cur.val>=biggest.val){
                    biggest=cur;
                }
                cur = cur.next;
            }
            if(cur.val>=biggest.val){
                biggest=cur;
            }
            if(cur.val<=val&&val<=cur.next.val){
                ListNode next=cur.next;
                cur.next = new ListNode(val);
                cur.next.next=next;
            }else{
                ListNode node=new ListNode(val);
                node.next=biggest.next;
                biggest.next=node;
            }
        }
        return head;
    }
    /**
     * 创建并打印一个值按升序排列的循环链表
     * 不包含重复元素，且相邻元素不能都只相差1
     *
     * @return
     */
    public static ListNode createAndPrintSortedCircularLinkedList() {
        // 创建不包含重复值且相邻元素差值不全为1的有序循环链表: 1 -> 3 -> 6 -> 10 -> 15 -> 1 -> ...
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node6 = new ListNode(6);
        ListNode node10 = new ListNode(10);
        ListNode node15 = new ListNode(15);

        // 连接节点形成循环链表
        node1.next = node3;
        node3.next = node6;
        node6.next = node10;
        node10.next = node15;
        node15.next = node1; // 形成循环

        return print(node1);
    }

    private static ListNode print(ListNode node1) {
        // 打印循环链表（限制打印次数避免无限循环）
        ListNode current = node1;
        int count = 0;
        int maxPrint = 10; // 最多打印10个节点

        System.out.print("循环链表: ");
        do {
            System.out.print(current.val);
            if (count < maxPrint - 1) {
                System.out.print(" -> ");
            }
            current = current.next;
            count++;
        } while (current != node1 && count < maxPrint);

        if (current == node1 && count > 0) {
            System.out.print("(...回到头部)");
        }
        System.out.println();
        return node1;
    }
}
