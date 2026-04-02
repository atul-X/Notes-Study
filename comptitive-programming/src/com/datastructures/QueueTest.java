package datastructures;

public class QueueTest {
    int size=5;
    int[] queue=new int[size];
    int front;
    int rear;
    QueueTest() {
        front =-1;
        rear=-1;
    }
    public boolean isEmpty(){
        if(front ==-1){
            return true;
        }
        return false;
    }
    boolean isFull() {
        if (rear == size - 1) {
            return true;
        }
        return false;
    }
    public void enQueue(int element){
        if(isFull()){
            System.out.println("the queue is full");
            System.exit(-1);
        }
        else {
            if(front==-1){
                front=0;
            }
            rear++;
            queue[rear]=element;
            System.out.println("Inserted -> " + element);
        }

    }
    public int deQueue(){
        int element = 0;
        if(isEmpty()){
            System.out.println("the queue is Empty");
        }else {
            element=queue[front];
            if(front>=rear){
                front=-1;
                rear=-1;
            }else {
                front++;
            }
            System.out.println("Deleted -> " + element);
            return (element);
        }
        return element;
    }
    public void display() {
        /* Function to display elements of Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront index-> " + front);
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print(queue[i] + "  ");

            System.out.println("\nRear index-> " + rear);
        }
    }
    public static void main(String args[]){
        QueueTest queue1= new QueueTest();
        queue1.enQueue(3);
        queue1.enQueue(1);
        queue1.enQueue(5);
        queue1.enQueue(7);
        queue1.deQueue();
        queue1.deQueue();


        queue1.enQueue(9);
        queue1.enQueue(9);

        queue1.display();
    }
}
