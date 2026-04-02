package algorithms.linkedlist;


public class MergeNodesinBetweenZeros {
    static ListNode head;
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int d) {
            val = d;
            next = null;
        }
    }
    public void insert(int data){
        ListNode nodeToBeAdded=new ListNode(data);
        ListNode temp=head;
        if(head==null){
            head=nodeToBeAdded;
            return;
        }

        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next=nodeToBeAdded;
    }
    public ListNode mergeNodes1(ListNode head) {
        ListNode prev = head;
        ListNode curr=head.next;
        int i=0;int itr=0;
        int count=0;
        while (curr!=null){
            if(curr.val!=0){
                count+=curr.val;
            }
            if(curr.val==0 ){
                prev.val=count;
                count=0;
                if(curr.next!=null){
                   prev= prev.next;
                }
            }
            curr=curr.next;
        }
        prev.next=null;

        return prev;
    }


    


public ListNode mergeNodes(ListNode head) {
    ListNode prev = head;
    ListNode curr = head.next;
    int sum = 0;

    while(curr != null){
        sum += curr.val;

        if(curr.val == 0){
            prev.val = sum;
            sum = 0;
            if(curr.next != null)
                prev = prev.next;
        }
        curr = curr.next;
    }
    prev.next = null;
    return head;
}

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }


    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        ListNode n=head;
        int count=0;
        while (temp!=null){
            temp=temp.next;
            count++;
        }
        int value= (int) Math.ceil(count/2);
        for(int i=0;i<=value+1;i++){
            n=n.next;
        }
        System.out.println(n);
        return n;
    }

    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder=new StringBuilder();
        ListNode temp=head;
        while (temp!=null){
            stringBuilder.append(temp.val);
            temp=temp.next;
        }
        int decimal=Integer.parseInt(stringBuilder.toString(),2);
        return  decimal;
    }


    public static void main(String args[]) {
        MergeNodesinBetweenZeros linklistImplimentation=new MergeNodesinBetweenZeros();
        linklistImplimentation.insert(0);
        linklistImplimentation.insert(24);
        linklistImplimentation.insert(14);
        linklistImplimentation.insert(0);
        linklistImplimentation.insert(2);
        linklistImplimentation.insert(2);
        linklistImplimentation.insert(0);
        linklistImplimentation.insert(13);
        linklistImplimentation.insert(20);
        linklistImplimentation.insert(0);
        linklistImplimentation.insert(22);
        linklistImplimentation.insert(23);
        linklistImplimentation.mergeNodes(head);
    }
}
