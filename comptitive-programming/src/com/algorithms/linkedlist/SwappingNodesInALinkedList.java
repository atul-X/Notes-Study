package algorithms.linkedlist;



public class SwappingNodesInALinkedList {
    public static  class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }




    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        int count=0;
        while (temp !=null){
            temp=temp.next;
            count++;
        }

        int endIndex=count-k+1;
        if(k==endIndex){
            return head;
        }
        int leftValue=0;
        int rightValue=0;
        ListNode transformList=head;
        for (int i=1;i<=count;i++){
            if (i==k){
                leftValue=transformList.val;
            }
            if (endIndex==i){
                rightValue= transformList.val;
            }
            transformList=transformList.next;
        }
        transformList=head;
        for (int i=1;i<=count;i++){
            if (i==k){
                transformList.val=rightValue;
            }
            if (endIndex==i){
                transformList.val=leftValue;
            }
            transformList=transformList.next;
        }

        return head;
    }

    public void swap(int[] arr,int left,int right){
        int temp=arr[left-1];
        arr[left-1]=arr[right-1];
        arr[right-1]=temp;
    }

    public static void main(String[] args) {
        int[] arr={1,2};
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
        SwappingNodesInALinkedList swappingNodesInALinkedList=new SwappingNodesInALinkedList();
        swappingNodesInALinkedList.swapNodes(listNode,1);

    }




}
