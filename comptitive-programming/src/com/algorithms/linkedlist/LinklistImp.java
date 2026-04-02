package algorithms.linkedlist;

public class LinklistImp {
    Node head;
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void insert(int data ){
        Node nodeNeedToBeAdded=new Node(data);
        Node temp=head;
        if(head==null){
            head=nodeNeedToBeAdded;
            return;
        }
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=nodeNeedToBeAdded;
    }
    public void show(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
    }

    public static void main(String args[]){
        LinklistImp linklistImp=new LinklistImp();
        linklistImp.insert(12);
        linklistImp.insert(13);
        linklistImp.show();

    }
}
