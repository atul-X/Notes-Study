package datastructures;
// Linked list implementation in Java

class LinkedList {
    // Creating a node
    Node head;

    static class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }
    }
    void add(int value){
        Node toBeAdded=new Node(value);
        Node temp=head;
        if(head==null){
            head=toBeAdded;
            return;
        }
        while (temp.next !=null){
            temp=temp.next;
        }
        temp.next=toBeAdded;

    }

    void print(){
        Node temp=head;
        while (temp !=null){
            System.out.printf(temp.value+"\n");
            temp=temp.next;
        }
    }
    void insertAtStart(int data){
        Node temp=new Node(data);
        temp.next=head;
        head=temp;
    }
    void insertAtSpecificLocation(int index,int data ){
        Node temp=new Node(data);
        Node n=head;
        if(index==0){
            temp.next=head;
            head=temp;
            return;
        }

        for(int i=0;i<index-1;i++){
            n=n.next;
        }
        temp.next=n.next;
        n.next=temp;
    }

    void delete(int index){
        Node temp=null;
        Node n=head;
        if(index==0){
            head=n.next;
            return;
        }
        for(int i=0;i<index-1;i++){
            n=n.next;
        }
        temp=n.next;
        n.next=temp.next;

    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
//
//        // Assign value values
//        linkedList.head = new Node(1);
//        Node second = new Node(2);
//        Node third = new Node(3);
//
//        // Connect nodess
//        linkedList.head.next = second;
//        second.next = third;
//
//        // printing node-value
//        while (linkedList.head != null) {
//            System.out.print(linkedList.head.value + " ");
//            linkedList.head = linkedList.head.next;
//        }
       linkedList.add(9);
       linkedList.add(10);
       linkedList.add(11);
//       linkedList.print();
       linkedList.insertAtStart(12);
       linkedList.insertAtSpecificLocation(0,4);
       linkedList.delete(0);
       linkedList.print();

    }
//public static void main(String args[]){
//    Map<Integer,String> numbers = new HashMap<>();
//    numbers.put(12,"qw");
//    numbers.put(8,"qe");
//    numbers.entrySet().iterator().next();
//    numbers.add(2);
//    numbers.add(23);
//    Iterator<Integer> it = numbers.iterator();
//    System.out.printf(String.valueOf(it.hasNext()));
//    while(it.hasNext()) {
//        Integer i = it.next();
//        if(i < 10) {
//            it.remove();
//        }
//    }
//    System.out.println(numbers);
//    System.out.println(    numbers.values().iterator().next());
//}
}

