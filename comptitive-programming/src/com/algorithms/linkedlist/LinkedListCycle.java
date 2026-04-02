package algorithms.linkedlist;

public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean hasCycle(ListNode head) {
        ListNode temp=head;
        int size=0;
        while (temp!=null){
          size++;
          temp=temp.next;
        }
        if(size<0){
         return false;
        }
        return true;
    }
}
