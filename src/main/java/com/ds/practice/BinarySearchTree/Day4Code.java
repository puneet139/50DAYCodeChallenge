package com.ds.practice.BinarySearchTree;

import java.util.Scanner;

public class Day4Code {

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
        System.out.println(calculateHeight(root));
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

    private static int calculateHeight(Node root)
    {
        return calculateHeightUtil(root);
    }

    private static int calculateHeightUtil(Node root)
    {
        if(root==null)
        {
            return 0;
        }else {
                int lheight = calculateHeightUtil(root.left);
                int rheight = calculateHeightUtil(root.right);
                if(lheight>rheight)
                    return lheight+1;
                else
                    return rheight+1;
        }
    }
}
