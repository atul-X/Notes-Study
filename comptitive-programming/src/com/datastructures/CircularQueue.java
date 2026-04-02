package com.datastructures;

public class CircularQueue {
    int size =5;
    int[] queue=new int[size];
    int front,rear;
    CircularQueue(){
        front=-1;
        rear=-1;
    }
    boolean isFull(){
        if(front==0 && rear==size-1 ){
            return true;
        }else {
            if (front == rear + 1) {
                return true;
            }
            return false;
        }
    }
    Boolean isEmpty(){
        if(front==-1){
            return true;
        }
        else {
            return false;
        }
    }
    void enQueue(int element){
        if (isFull()){
            System.out.println("the Array is Full");
            System.exit(-1);
        }else{
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            queue[rear]=element;
            System.out.println("inserted -> "+element);
        }
    }
    int deQueue(){
        int element = 0;
        if(isEmpty()){
            System.out.println("The queue is empty");
            System.exit(-1);
        }else {
            element=queue[rear];
            if (front==rear) {
                front=-1;
                rear=-1;
            }else {
                 front=(front+1)%size;
            }
            return (element);
        }
        return element;
    }

    void display() {
        /* Function to display status of Circular Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % size)
                System.out.print(queue[i] + " ");
            System.out.println(queue[i]);
            System.out.println("Rear -> " + rear);
        }
    }
    public static void main(String[] args){
        CircularQueue queue1= new CircularQueue();
        queue1.enQueue(3);
        queue1.enQueue(41);
        queue1.enQueue(42);
        queue1.enQueue(43);
        queue1.deQueue();

        queue1.enQueue(44);
        queue1.enQueue(46);

        queue1.display();
    }



}
