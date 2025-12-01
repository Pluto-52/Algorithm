package LinkedList;

import LinkedList.listNode.ListNode;

import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int s = sc.nextInt();
        ListNode head = createListNode(s);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast.next!=null)fast=fast.next;
        }
        ListNode reverse = ListNode.reverseList(slow.next);
        slow.next=null;
        ListNode temp=head;
        while(reverse!=null){
            if(reverse.val!=temp.val)return false;
            reverse=reverse.next;
            temp=temp.next;
        }
        return true;
    }

    public static ListNode createListNode(int n){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        for(int i=1;i<=n;i++){
            if (i<=n/2) {
                cur.next=new ListNode(i);
                cur=cur.next;
            }
            if (i>n/2) {
                cur.next=new ListNode(n-i+1);
                cur=cur.next;
            }
        }
        ListNode.printList(dummy.next);
        return dummy.next;
    }
}
