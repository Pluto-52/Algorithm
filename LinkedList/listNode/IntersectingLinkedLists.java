package LinkedList.listNode;

public class IntersectingLinkedLists {

    /**
     * 创建两个有重合部分的单向链表
     * @param list1Length 第一个链表独有的长度
     * @param list2Length 第二个链表独有的长度
     * @param commonLength 两个链表共有的长度
     * @return 包含两个链表头节点的数组
     */
    public static ListNode[] createIntersectingLists(int list1Length, int list2Length, int commonLength) {
        // 边界条件检查
        if (list1Length < 0 || list2Length < 0 || commonLength < 0) {
            return new ListNode[]{null, null};
        }

        // 创建共同部分
        ListNode commonHead = createListWithLength(commonLength, 101);

        // 创建第一个链表独有部分
        ListNode head1 = createListWithLength(list1Length, 1);
        if (head1 != null) {
            ListNode tail1 = getTail(head1);
            tail1.next = commonHead;
        } else {
            head1 = commonHead;
        }

        // 创建第二个链表独有部分
        ListNode head2 = createListWithLength(list2Length, 20);
        if (head2 != null) {
            ListNode tail2 = getTail(head2);
            tail2.next = commonHead;
        } else {
            head2 = commonHead;
        }

        return new ListNode[]{head1, head2};
    }

    /**
     * 创建指定长度的链表
     * @param length 链表长度
     * @param startValue 起始值
     * @return 链表头节点
     */
    private static ListNode createListWithLength(int length, int startValue) {
        if (length <= 0) return null;

        ListNode head = new ListNode(startValue);
        ListNode current = head;

        for (int i = 1; i < length; i++) {
            current.next = new ListNode(startValue + i);
            current = current.next;
        }

        return head;
    }

    /**
     * 获取链表尾节点
     * @param head 链表头节点
     * @return 尾节点
     */
    private static ListNode getTail(ListNode head) {
        if (head == null) return null;

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    /**
     * 打印链表
     * @param head 链表头节点
     * @param listName 链表名称
     */
    public static void printList(ListNode head, String listName) {
        System.out.print(listName + ": ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * 创建简单的相交链表示例
     * @return 包含两个链表头节点的数组
     */
    public static ListNode[] createSimpleIntersectingLists() {
        // 共同部分: 101 -> 102 -> 103
        ListNode common3 = new ListNode(103);
        ListNode common2 = new ListNode(102);
        ListNode common1 = new ListNode(101);
        common2.next = common3;
        common1.next = common2;

        // 第一个链表: 1 -> 2 -> 3 -> 101 -> 102 -> 103
        ListNode list1Node3 = new ListNode(3);
        ListNode list1Node2 = new ListNode(2);
        ListNode head1 = new ListNode(1);
        list1Node2.next = list1Node3;
        list1Node3.next = common1;
        head1.next = list1Node2;

        // 第二个链表: 11 -> 12 -> 101 -> 102 -> 103
        ListNode list2Node2 = new ListNode(12);
        ListNode head2 = new ListNode(11);
        list2Node2.next = common1;
        head2.next = list2Node2;

        return new ListNode[]{head1, head2};
    }

    /**
     * 查找两个链表的相交节点（用于验证）
     * @param head1 第一个链表头节点
     * @param head2 第二个链表头节点
     * @return 相交节点，如果没有相交则返回null
     */
    public static ListNode findIntersection(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;

        ListNode a = head1;
        ListNode b = head2;

        // 当两个指针相遇时，要么是相交节点，要么都是null
        while (a != b) {
            a = a == null ? head2 : a.next;
            b = b == null ? head1 : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        // 示例1: 创建自定义长度的相交链表
        System.out.println("=== 创建自定义长度的相交链表 ===");
        ListNode[] lists1 = createIntersectingLists(3, 2, 3);
        printList(lists1[0], "链表1");
        printList(lists1[1], "链表2");

        // 示例2: 创建简单相交链表
        System.out.println("\n=== 创建简单相交链表 ===");
        ListNode[] lists2 = createSimpleIntersectingLists();
        printList(lists2[0], "链表1");
        printList(lists2[1], "链表2");

        // 找到相交节点并打印
        ListNode intersection = findIntersection(lists2[0], lists2[1]);
        if (intersection != null) {
            System.out.println("相交节点值: " + intersection.val);
        }
    }
}
