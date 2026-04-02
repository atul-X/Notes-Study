package algorithms.linkedlist;

import java.util.ArrayList;

public class PalindromeLinkedList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public boolean isPalindrome(ListNode head) {
          ListNode temp=head;
          ArrayList<Integer> arrayList=new ArrayList<>();
          while (temp!=null){
            arrayList.add(temp.val);
            temp=temp.next;
          }
          int start=0;
          int end=arrayList.size()-1;
          for (int i=0;i<arrayList.size();i++){
                if(arrayList.get(start)!=arrayList.get(end)){
                    return false;
                }
                start++;
                end--;
          }
          return true;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,1};
        ListNode result = null;
        for (int i=0;i<arr.length;i++) {
            ListNode nodeNeedToBeAdded=new ListNode(arr[i]);
            ListNode temp1=result;
            if (result == null) {
                result=nodeNeedToBeAdded;
                continue;
            }
            while (temp1.next!=null){
                temp1=temp1.next;
            }
            temp1.next=nodeNeedToBeAdded;
        }
        PalindromeLinkedList palindromeLinkedList=new PalindromeLinkedList();
        palindromeLinkedList.isPalindrome(result);
    }
}
