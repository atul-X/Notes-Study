package algorithms.linkedlist;

public class DoublyLinkList {
    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next,Node prev) {
            this.value = value;
            this.next = next;
            this.prev=prev;
        }
    }
    Node head;
    int size;

    public DoublyLinkList(int size) {
        this.size = size;
    }

    public void insertFirst(int val){
        Node nodeNeedToAdded=new Node(val);
        nodeNeedToAdded.next=head;
        nodeNeedToAdded.prev=null;
        if(head !=null){
            head.prev=nodeNeedToAdded;
        }
        head=nodeNeedToAdded;
        size++;
    }




    public static void main(String[] args) {

    }
}
