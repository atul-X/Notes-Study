package algorithms.tree;

import java.util.Scanner;

public class Tress {
    static Scanner scanner=null;
    public static void main(String args[]){
        scanner=new Scanner(System.in);
        Node root=createTree();
        System.out.println("\n +"+ root);
        System.out.println("PreOrder ");

        inOrder(root);
        System.out.println("\n");
        preOrder(root);
        System.out.println("\n");
        postOrder(root);
        System.out.println("\n");

        height(root);
    }
    static Node createTree(){
         Node root =null;
        System.out.println("Enter data :");
        int data = scanner.nextInt();
        if(data==-1) return null;
        root=new Node(data);
        System.out.println("Enter left for "+data);
        root.left=createTree();
        System.out.println("Enter right for "+data);
        root.right=createTree();
        return root;

    }
    static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        System.out.print(root.data);
        postOrder(root.right);
        System.out.print(root.data+" ");

    }
    static int height(Node root){
        if (root==null)
            return 0;
       return Math.max(height(root.left),height(root.right))+1;
    }

}

class Node{
    Node left,right;
    int data ;

    public Node(int data) {
        this.data = data;
    }
}
