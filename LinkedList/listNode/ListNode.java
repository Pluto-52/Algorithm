package LinkedList.listNode;

import java.util.*;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int  val) {
        this.val=val;
    }
    public static ListNode createListNode(int n){
        ListNode head = null;
        ListNode tail = null;
        // 依次添加节点
        for (int i = 1; i <= n; i++) {
            ListNode newNode = new ListNode(i);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        // 打印链表
        printList(head);
        return head;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    /**
     * 创建带环链表
     */
    /**
     * 创建完全随机的带环链表（随机长度和随机环位置）
     * @return 带环链表的头节点
     */
    public static ListNode createFullyRandomCycleLinkedList() {
        Random random = new Random();
        int length = random.nextInt(10) + 3; // 长度3-12
        int cycleStartPos = random.nextInt(length); // 环位置0到length-1

        return createRandomCycleLinkedList(length, cycleStartPos);
    }
    /**
     * 创建一个带环的随机链表
     * @param length 链表总长度
     * @param cycleStartPos 环开始的位置（从0开始计数）
     * @return 带环链表的头节点
     */
    public static ListNode createRandomCycleLinkedList(int length, int cycleStartPos) {
        if (cycleStartPos < 0 || cycleStartPos >= length) {
            return null;
        }

        // 创建节点数组
        ListNode[] nodes = new ListNode[length];

        // 初始化所有节点
        for (int i = 0; i < length; i++) {
            nodes[i] = new ListNode(new Random().nextInt(100)); // 随机值0-99
        }

        // 连接节点形成链表
        for (int i = 0; i < length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // 创建环：将最后一个节点指向cycleStartPos位置的节点
        nodes[length - 1].next = nodes[cycleStartPos];

        return nodes[0]; // 返回头节点
    }
    /**
     * 打印链表（最多打印20个节点，避免无限循环）
     * @param head 链表头节点
     */
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("空链表");
            return;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        List<Integer> values = new ArrayList<>();

        int count = 0;
        while (current != null && count < 20) { // 最多打印20个节点
            if (visited.contains(current)) {
                System.out.println("检测到环，环开始于值: " + current.val);
                break;
            }

            visited.add(current);
            values.add(current.val);
            current = current.next;
            count++;
        }

        System.out.println("链表值序列: " + values);
    }
}
