package algorithms.linkedlist;

public class IntersectionOfTwoLinkedLists {
    public static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        while (temp1!=null){

            while (temp2!=null){
                if(temp1.val== temp2.val){
                   return temp1;
                }
                temp2=temp2.next;
            }
            temp2=headB;
            temp1=temp1.next;
        }
        return null;
    }



    public static void main(String[] args) {
        int[] arr1={1,2,4};
        int[] arr2={1,3,4};
        ListNode listNode1 = null;
        for (int t=0;t<arr1.length;t++){
            ListNode toBeAdded=new ListNode(arr1[t]);
            ListNode temp1=listNode1;
            if(listNode1==null){
                listNode1=toBeAdded;
                continue;
            }
            while (temp1.next !=null){
                temp1=temp1.next;
            }
            temp1.next=toBeAdded;
        }
        ListNode listNode2 = null;
        for (int t=0;t<arr2.length;t++){
            ListNode toBeAdded=new ListNode(arr2[t]);
            ListNode temp1=listNode2;
            if(listNode2==null){
                listNode2=toBeAdded;
                continue;
            }
            while (temp1.next !=null){
                temp1=temp1.next;
            }
            temp1.next=toBeAdded;
        }

    }
}
