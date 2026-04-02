package algorithms.linkedlist;

import java.util.ArrayList;

public class MaximumTwinSumOfALinkedList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
      public int pairSum(ListNode head) {
            ListNode temp=head;
          ArrayList<Integer> list=new ArrayList<Integer>();

            int size=0;
            int maxSum=0;
            while (temp!=null){
                size++;
                list.add(temp.val);
                temp=temp.next;
            }
            for (int i=0;i<list.size()/2;i++){
                int pairValue1=list.get(i);
                int calculteTwin= size-1-i;
                int pairValue2=list.get(calculteTwin);
                int sum=pairValue1+pairValue2;
                maxSum=Math.max(maxSum,sum);
            }

//            temp=head;
//            int index=0;
//            for(int j=0;j<=size/2;j++){
//                int pairValue1=temp.val;
//                int calculteTwin= size-1-index;
//                ListNode temp1=temp;
//                for(int i=j;i<=calculteTwin;i++){
//                    temp1=temp1.next;
//                }
//                int pairValue2=temp1.val;
//                int sum=pairValue1+pairValue2;
//                maxSum=Math.max(maxSum,sum);
//                temp=temp.next;
//                index++;
//            }
            return  maxSum;
      }



    public static void main(String[] args) {
        int[] arr={5,4,2,1};
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
        MaximumTwinSumOfALinkedList maximumTwinSumOfALinkedList=new MaximumTwinSumOfALinkedList();
        maximumTwinSumOfALinkedList.pairSum(listNode);


    }
}
