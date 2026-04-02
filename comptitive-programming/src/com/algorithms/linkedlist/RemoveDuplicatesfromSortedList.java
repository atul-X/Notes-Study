package algorithms.linkedlist;

public class RemoveDuplicatesfromSortedList {

 public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public static ListNode deleteDuplicates(ListNode head) {
     ListNode temp=head;
     ListNode result=null;
     while (temp!=null){
         if(temp.next==null){
             return head;
         }
           if(temp.val!= temp.next.val){
               ListNode nodeToBeAdded=new ListNode(temp.val);
               ListNode listNode1=result;
               if(result==null){
                   result=nodeToBeAdded;

                   temp=temp.next;

                   if(temp.next==null){
                       ListNode nodeToBeAdded1=new ListNode(temp.val);
                       listNode1=result;
                       while (listNode1.next!=null){
                           listNode1=listNode1.next;
                       }
                       listNode1.next=nodeToBeAdded1;
                       break;
                   }
                   continue;
               }
               while (listNode1.next!=null){
                   listNode1=listNode1.next;
               }
               listNode1.next=nodeToBeAdded;
           }
           temp=temp.next;
           if(temp.next==null){
               ListNode nodeToBeAdded=new ListNode(temp.val);
               ListNode listNode1=result;
               if(result==null){
                   result=nodeToBeAdded;
                   temp=temp.next;
                   continue;
               }
               while (listNode1.next!=null){
                   listNode1=listNode1.next;
               }
               listNode1.next=nodeToBeAdded;
               break;
           }
     }
     return result;
 }

    public static void main(String[] args) {
        int[] arr={1,1,2};
        ListNode listNode = null;
        for (int t=0;t<arr.length;t++){
            ListNode toBeAdded=new ListNode(arr[t]);
            ListNode temp1=listNode;
            if(listNode==null){
                listNode=toBeAdded;
                continue;
            }
            while (temp1.next !=null){
                temp1=temp1.next;
            }
            temp1.next=toBeAdded;
        }
        RemoveDuplicatesfromSortedList swappingNodesInALinkedList=new RemoveDuplicatesfromSortedList();
        RemoveDuplicatesfromSortedList.deleteDuplicates(listNode);
    }
}
