package com.ds.practice.BinarySearchTree;

import java.util.Scanner;

public class Day6Code {

    private static Node root;

    static class Node{
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int val,Node left,Node right,Node parent){
            value=val;
            this.left=left;
            this.right=right;
            this.parent=parent;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyQueue queue = new MyQueue();
        System.out.println("Enter the element to insert");
        int number = sc.nextInt();
        boolean exit = false;
        root = new Node(number,null,null,null);
        queue.insert(root.value);
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
        printLevelOrderTraversal(queue);
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

    private static void printLevelOrderTraversal(MyQueue queue){
        while(!queue.isEmpty()){
            int frontElement = queue.remove();
            System.out.println(frontElement);
            Node frontNode = searchTree(frontElement,root);
            if(frontNode.left!=null)
                queue.insert(frontNode.left.value);
            if(frontNode.right!=null)
                queue.insert(frontNode.right.value);
        }
    }
}
