package LinkedList.listNode;

public class MultilevelLinkedList {

    /**
     * 创建多级双向链表并打印结构
     */
    public static  Node createAndPrintMultilevelList() {
        // 创建主链表: 1-2-3-4-5-6
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // 连接主链表
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        // 创建子链表1: 7-8-9-10，连接到node3
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;

        // 将子链表连接到node3
        node3.child = node7;

        // 创建子链表2: 11-12，连接到node8
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node11.next = node12;
        node12.prev = node11;

        // 将子链表连接到node8
        node8.child = node11;

        // 打印原始多级链表结构
        System.out.println("原始多级双向链表:");
        printMultilevelStructure(node1);

        // 扁平化链表并打印
        Node flattened = flatten(node1);
        System.out.println("\n扁平化后的链表:");
        printFlattenedList(flattened);
        return node1;
    }

    /**
     * 扁平化多级双向链表
     * @param head 链表头节点
     * @return 扁平化后的链表头节点
     */
    public static Node flatten(Node head) {
        if (head == null) return head;

        Node current = head;
        while (current != null) {
            if (current.child != null) {
                // 保存下一个节点
                Node nextNode = current.next;

                // 连接子链表
                current.next = current.child;
                current.child.prev = current;

                // 找到子链表的尾部
                Node childTail = current.child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                // 重新连接原next节点
                if (nextNode != null) {
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }

                // 清除child指针
                current.child = null;
            }
            current = current.next;
        }

        return head;
    }

    /**
     * 打印多级链表结构（递归方式）
     * @param head 链表头节点
     */
    public static void printMultilevelStructure(Node head) {
        printMultilevelStructureHelper(head, 0);
    }

    private static void printMultilevelStructureHelper(Node node, int level) {
        if (node == null) return;

        Node current = node;
        while (current != null) {
            // 打印缩进
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }

            System.out.print(current.val);
            if (current.child != null) {
                System.out.println(" (有子链表):");
                printMultilevelStructureHelper(current.child, level + 1);
            } else {
                System.out.println();
            }

            current = current.next;
        }
    }

    /**
     * 打印扁平化后的链表
     * @param head 链表头节点
     */
    public static void printFlattenedList(Node head) {
        if (head == null) return;

        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 打印当前层级链表
     * @param head 链表头节点
     */
    public static void printMultilevelList(Node head) {
        if (head == null) return;

        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.child != null) {
                System.out.print("(有子链表)");
            }
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // 定义多级双向链表节点
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
