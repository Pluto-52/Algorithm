package HashTable;

import java.util.HashMap;

public class LRUCache {
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private HashMap<Integer,ListNode> map;
    public LRUCache(int capacity) {
        head=new ListNode(-1,-1);
        tail=new ListNode(-1,-1);
        head.next=tail;
        tail.pre=head;
        this.capacity=capacity;
    }
    public int get(int key) {
        ListNode node=map.get(key);
        if(node==null){
            return -1;
        }
        moveToTail(node,node.val);
        return node.val;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            moveToTail(map.get(key),value);
        }
        else{
            if(map.size()==capacity){
                ListNode node=head.next;
                deleteNode(node);
                map.remove(node.key);
            }
            ListNode node=new ListNode(key,value);
            insertToTail(node);
        }
    }
    public void moveToTail(ListNode node,int val){
        deleteNode(node);
        node.val=val;
        insertToTail(node);
    }
    public void deleteNode(ListNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    private void insertToTail(ListNode node){
        tail.pre.next=node;
        node.pre=tail.pre;
        node.next=tail;
        tail.pre=node;
    }
}

 class ListNode{
    public int key;
    public int val;
    public ListNode pre;
    public ListNode next;
    public ListNode(int key,int val){
        this.key=key;
        this.val=val;
    }
}
