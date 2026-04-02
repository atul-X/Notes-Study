package datastructures;

public class QueueArrayImplementation {
    int front =-1;
    int rear =-1;
    int capacity=5;
    int[] queue=new int[capacity];
    public void enQueue(int data ){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }else {
            if (front==-1){
                front=0;
            }
            rear++;
            queue[rear]=data;
        }
    }

    public void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is Emepty");
            return;
        }
        else {
            front++;
        }
    }
    public void display(){
        for(int i=front;i<=rear;i++){
            System.out.print(queue[i]+ "\t");
        }
    }
    public boolean isEmpty(){
        if(front==-1 && rear==-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(rear==capacity-1) {
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        QueueArrayImplementation queue1= new QueueArrayImplementation();
        queue1.enQueue(3);
        queue1.enQueue(4);
        queue1.enQueue(6);
        queue1.enQueue(5);
        queue1.deQueue();
        queue1.deQueue();


        queue1.enQueue(2);
//        queue1.enQueue(4);

        queue1.display();
    }
}
