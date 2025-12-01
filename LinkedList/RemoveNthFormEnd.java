package LinkedList;
import LinkedList.listNode.ListNode;

import java.util.Scanner;

public class RemoveNthFormEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        ListNode head = ListNode.createListNode(s);
        int k = sc.nextInt();
        ListNode current = removeNthFromEnd(head, k);
        System.out.println("删除倒数第"+k+"个节点后/n");
        ListNode.printList(current);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0)return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy;
        ListNode second=dummy;
        for (int j = 0; j < n; j++) {
                second=second.next;
        }

        while(second.next!=null){
            first=first.next;
            second=second.next;
        }
        first.next=first.next.next;
        return dummy.next;
    }
}
