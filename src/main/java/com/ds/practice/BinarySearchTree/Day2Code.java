package com.ds.practice.BinarySearchTree;

import java.util.Scanner;

public class Day2Code {

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
        System.out.println("Enter the element to insert");
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
        System.out.println("Enter the element to search");
        int numSearch = sc.nextInt();
        Node searchNode = searchTree(numSearch,root);
        if(searchNode!=null)
            System.out.println(searchNode.value);
        else{
            System.out.println("Node not found");
        }
        Node searchNodeIter = searchTreeIteratively(numSearch,root);
        if(searchNodeIter!=null)
            System.out.println(searchNodeIter.value);
        else{
            System.out.println("Node not found");
        }
        System.out.println(findTreeMinimum(root).value);
        System.out.println(findTreeMaximum(root).value);
        System.out.println("Enter the node whose successor to find");
        int numSuc = sc.nextInt();
        int successorNode = findSuccessor(numSuc);
        System.out.println(successorNode);
        System.out.println("Enter the node whose predeccesor to find");
        int numPre = sc.nextInt();
        System.out.println(findPredeccessor(numPre));
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

    private static Node searchTreeIteratively(int num,Node root){
        Node n = root;
        while (n!=null){
            if(n.value==num){
                return n;
            }else if(n.value>num){
                n=n.left;
            }else if(n.value<num){
                n=n.right;
            }
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

    private static Node findTreeMaximum(Node root){
        if(root.right==null)
        {
            return root;
        }else{
            Node n = root;
            n = findTreeMaximum(root.right);
            return n;
        }
    }

    private static int findSuccessor(int num){
        if(root.value==num)
        {
            return findTreeMinimum(root.right).value;
        }else{
            Node y = searchTree(num,root);
            if(y.right!=null){
                return y.right.value;
            }
            else {
                Node p = y.parent;
                while(p!=null && p.right==y){
                    y=p;
                    p=y.parent;
                }
                return p.value;
            }

        }
    }

    private static int findPredeccessor(int num){
        if(root.value==num)
        {
            return findTreeMaximum(root.left).value;
        }else{
            Node y = searchTree(num,root);
            if(y.left!=null){
               return findTreeMaximum(y.left).value;
            }else {
                return y.parent.value;
            }
        }
    }
}
