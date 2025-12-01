package LinkedList;
import LinkedList.listNode.ListNode;
public class DetectCycle {
    public static void main(String[] args) {
        // 示例1: 创建指定长度和环位置的链表
        System.out.println("=== 创建指定参数的带环链表 ===");
        ListNode list1 = ListNode.createRandomCycleLinkedList(8, 3);
        ListNode.printLinkedList(list1);
        System.out.println("环的入口节点为"+detectCycle(list1).val);

        // 示例2: 创建完全随机的带环链表
        System.out.println("\n=== 创建完全随机的带环链表 ===");
        ListNode list2 = ListNode.createFullyRandomCycleLinkedList();
        ListNode.printLinkedList(list2);
        System.out.println("环的入口节点为"+detectCycle2(list2).val);
    }
    public static ListNode getNodeInLoop(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode slow=head.next;
        ListNode fast=slow.next;
        while(slow!=null&&fast!=null){
            if(slow==fast)return slow;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)fast=fast.next;
        }
        return null;
    }
    /**
     * 获取环的入口节点（计算环的长度）
     * @param head 链表的头节点
     * @return 环的入口节点
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode inLoop=getNodeInLoop(head);
        if(inLoop==null)return null;
        int loopCount=1;
        for(ListNode cur=inLoop;cur.next!=inLoop;cur=cur.next)loopCount++;
        ListNode first=head;
        ListNode second=head;
        for (int i = 0; i < loopCount; i++) {
            second=second.next;
        }
        while(first!=second){
            first=first.next;
            second=second.next;
        }
        return first;
    }
    /**
     * 获取环的入口节点（不计算环的长度）
     * @param head 链表头节点
     * @return 环的入口节点
     */
    public static ListNode detectCycle2(ListNode head) {
        ListNode inLoop=getNodeInLoop(head);
        if(inLoop==null)return null;
        ListNode node=head;
        while(node!=inLoop){
            node=node.next;
            inLoop=inLoop.next;
        }
        return node;
    }
}
