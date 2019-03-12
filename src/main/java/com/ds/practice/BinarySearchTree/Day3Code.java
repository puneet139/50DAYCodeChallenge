package com.ds.practice.BinarySearchTree;

import java.util.Scanner;

public class Day3Code {

    private static Node root;

    static class Node{
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int val,Node l,Node r,Node p){
            value=val;
            left=l;
            right=r;
            parent=p;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to insert");
        int number = sc.nextInt();
        boolean exit = false;
        root = new Node(number,null,null,null);
        while(!exit)
        {
            System.out.println("Would you like to continue y/n");
            if("n".equalsIgnoreCase(sc.next()))
            {
                exit=true;
                break;
            }
            System.out.println("Enter the element to insert");
            number = sc.nextInt();
            insert(number);
        }
        printTree(root);
        System.out.println("Enter the number to delete");
        int numToDelete = sc.nextInt();
        deleteFromTree(numToDelete);
        printTree(root);
    }

    private static void insert(int number){
        root = insertUtil(number,root,null);
    }

    private static Node insertUtil(int number,Node root,Node parent){
        if(root==null){
            Node newNode = new Node(number,null,null,parent);
            return newNode;
        }else if(number<root.value){
            root.left = insertUtil(number,root.left,root);
        }else if(number>root.value){
            root.right = insertUtil(number,root.right,root);
        }
        return root;
    }

    private static void printTree(Node root){
        if(root!=null){
            printTree(root.left);
            System.out.println(root.value);
            printTree(root.right);
        }
    }

    private static Node searchTree(int num,Node root){
        if(root==null)
            return null;
        else if(root!=null && root.value==num){
            return root;
        }else if(num<root.value){
            return searchTree(num,root.left);
        }else if(num>root.value){
            return searchTree(num,root.right);
        }
        return null;
    }

    private static Node findTreeMinimum(Node root){
        if(root.left==null)
        {
            return root;
        }else{
            Node n = root;
            n = findTreeMinimum(root.left);
            return n;
        }
    }

    private static void transplant(Node r,Node u,Node v){
        if(u.parent==null)
        {
            root = v;
        }else if(u==u.parent.left)
        {
            u.parent.left = v;
        }else if(u==u.parent.right){
            u.parent.right=v;
        }
        if(v!=null)
        {
            v.parent=u.parent;
        }

    }

    private static void deleteFromTree(int number){
        Node n = searchTree(number,root);
        if(n!=null){
            if(n.left==null) {
                transplant(root, n, n.right);
            }
            else if(n.right==null)
                transplant(root,n,n.left);
            else{
                Node y = findTreeMinimum(n.right);
                if(y.parent!=n)
                {
                    transplant(root,y,y.right);
                    y.right = n.right;
                    y.right.parent=y;
                }
                transplant(root,y,y.left);
                y.left=n.left;
                y.left.parent=y;
            }
            }
    }

}
