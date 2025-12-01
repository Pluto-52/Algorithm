package LinkedList;
import LinkedList.listNode.IntersectingLinkedLists;
import LinkedList.listNode.ListNode;

public class GetIntersectionNode {
    public static void main(String[] args) {
        // 创建两个有重合点的单向链表
        ListNode[] list = IntersectingLinkedLists.createSimpleIntersectingLists();
        IntersectingLinkedLists.printList(list[0], "链表1");
        IntersectingLinkedLists.printList(list[1], "链表2");
        System.out.println("相交节点："+getIntersectionNode(list[0], list[1]).val);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        int lenA=0;
        int lenB=0;
        while(a!=null){
            lenA++;
            a=a.next;
        }
        while(b!=null){
            lenB++;
            b=b.next;
        }
        // 重新指向头节点
        ListNode curA = headA;
        ListNode curB = headB;

        // 调整较长链表的起点
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
        }

        // 同时移动两个指针寻找相交点
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
