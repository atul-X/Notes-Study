package algorithms.linkedlist;

import java.util.ArrayList;

public class DesignHashMap {
    ListNode[] list=null;
    public static class ListNode{
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public ListNode(int key, int value, ListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public DesignHashMap() {
        list=new ListNode[1000];
    }

    public void put(int key, int value) {
        int index =getIndex(key);
        ListNode listNode=findElement(index,key);
        if(listNode.next==null){
            listNode.next=new ListNode(key,value);
        }else {
            listNode.next.value=value;
        }
    }

    public int get(int key) {
        //Retrieve the hashed index
        int index = getIndex(key);

        ListNode prev = findElement(index,key);
        if(prev.next==null)
            return -1;
        else
            return prev.next.value;

    }

    public void remove(int key) {
        //Retrieve the hashed index
        int index = getIndex(key);
        ListNode prev = findElement(index, key);

        //Removing element from a linkedlist
        if(prev.next != null)
            prev.next = prev.next.next;
    }
    public int getIndex(int key){
        return Integer.hashCode(key) % list.length;
    }
    public ListNode findElement(int index,int key){
        if(list[index]==null){
            return list[index]=new ListNode(-1,-1);
        }
        ListNode prev = list[index];
        while(prev.next!=null && prev.next.key!=key){
            prev = prev.next;
        }
        return prev;
    }
    public static void main(String[] args) {
        DesignHashMap designHashMap=new DesignHashMap();
        designHashMap.put(1,1);
        designHashMap.put(2,2);
        designHashMap.get(1);
        designHashMap.get(3);
        designHashMap.put(2,1);
        designHashMap.get(2);
        designHashMap.remove(2);
        designHashMap.get(2);
    }
}
