package com.ds.practice.BinarySearchTree;

import java.awt.peer.SystemTrayPeer;
import java.util.Scanner;

public class BSTExample {

    private static Node root;

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int r, Node l, Node ri,Node p){
            value=r;
            left=l;
            right=ri;
            parent = p;
        }
    }

    BSTExample(){
        root=null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Enter number to insert");
        int num = sc.nextInt();
        root = new Node(num,null,null,null);
        while(!exit) {
            System.out.println("Would you like to continue y/n");
            if("n".equalsIgnoreCase(sc.next()))
            {
                exit=true;
                break;
            }
            System.out.println("Enter number to insert");
            num = sc.nextInt();
            insert(num,root);
        }
        printTree(root);
        System.out.println("Enter the number to be searched");
        int numberToSearch = sc.nextInt();
        System.out.println(searchTree(root,numberToSearch));
        System.out.println("Enter the number to be deleted");
        int numberToDelete = sc.nextInt();
        deleteFromTree(numberToDelete);
        printTree(root);
    }

    private static void insert(int number,Node rt)
    {
        root = insertUtil(number,rt,null);
    }

    private static Node insertUtil(int num, Node root,Node parent){
        if(root==null)
        {
            Node newNode = new Node(num,null,null,parent);
            return newNode;
        }else
        {
            if(root.value>num)
            {
                root.left = insertUtil(num,root.left,root);
            }else if(root.value<num)
            {
                root.right = insertUtil(num,root.right,root);
            }
        }
        return root;
    }

    private static void printTree(Node root)
    {
        if(root==null && root.parent!=null)
            System.out.println(root.parent.value);
        if(root.left!=null)
        {
            printTree(root.left);
        }
        System.out.println(root.value);
        if(root.right!=null)
        {
            printTree(root.right);
        }
    }

    private static boolean searchTree(Node root, int num){
        if(root==null)
            return false;
        else if(root.value==num)
            return true;
        else if(root.value<num)
        {
            return searchTree(root.right,num);
        }else if(root.value>num){
            return searchTree(root.left,num);
        }
        return false;
    }

    private static void deleteFromTree(int number)
    {
        root = deleteFromTreeUtil(root,number);
    }

    private static Node deleteFromTreeUtil(Node root, int number)
    {
        if(root==null)
            return root;
        if(root.value<number)
        {
            root.right = deleteFromTreeUtil(root.right,number);
        }else if(root.value>number)
        {
           root.left = deleteFromTreeUtil(root.left,number);
        }else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            Node n= findInorderSuccessor(root);
            root.right = deleteFromTreeUtil(root.right,n.value);
        }
        return root;
    }

    private static Node findInorderSuccessor(Node root)
    {
        Node right = root.right;
        Node successor = null;
        if(right!=null)
        {
            while(right!=null && right.left!=null){
                right = right.left;
            }
            successor = right;
        }
        return successor;
    }
}
