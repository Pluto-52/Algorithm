package LinkedList;

import LinkedList.listNode.ListNode;

import java.util.Scanner;

public class ReorderList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode listNode = ListNode.createListNode(n);
        ListNode.printList(listNode);
        ListNode head = reorderList(listNode);
        System.out.println("重排后：");
        ListNode.printList(head);
    }

    public static ListNode reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next!=null)fast=fast.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        return link(head,ListNode.reverseList( temp),dummy);
    }
    public static ListNode link(ListNode node1,ListNode node2,ListNode dummy){
        ListNode pre =dummy;
        while(node1!=null&&node2!=null){
            ListNode temp=node1.next;
            pre.next=node1;
            node1.next=node2;
            pre=node2;
            node1=temp;
            node2=node2.next;
        }
        if(node1!=null){
            pre.next=node1;
        }
        return dummy.next;
    }
}
