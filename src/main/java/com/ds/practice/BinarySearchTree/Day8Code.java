package com.ds.practice.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day8Code {

    private static Node root;

    static class Node{
        int data;
        Node left,right;

        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int i=0;i<testCases;i++){
            int numEdges = sc.nextInt();
            for(int j=0;j<numEdges;j++){
                int firstNode = sc.nextInt();
                int secondNode = sc.nextInt();
                Node n = findNode(firstNode);
                String rightOrLeft = sc.next();
                insertInTree(n,secondNode,rightOrLeft);
            }
        }
        printTree(root);
        System.out.println(checkBST(root));
    }

    private static Node findNode(int val){
        if(root==null){
            root = new Node(val);
        }else if(root.data==val){
            return root;
        } else if(root.left!=null && root.left.data==val){
            return root.left;
        }else if(root.right!=null && root.right.data==val){
            return root.right;
        }
        return root;
    }

    private static void insertInTree(Node first,int secondVal,String flag){
        if("R".equals(flag)){
            Node second = new Node(secondVal);
            first.right=second;
        }else if("L".equals(flag)){
            Node second = new Node(secondVal);
            first.left=second;
        }
    }

    private static void printTree(Node root){
        if(root!=null){
            printTree(root.left);
            System.out.println(root.data);
            printTree(root.right);
        }
    }

    private static int checkBST(Node root){
            if(root==null)
                return 1;
            if(root.left!=null){
                if(!(root.left.data<root.data))
                    return 0;
            }
            if(root.right!=null){
                if(!(root.right.data>root.data))
                    return 0;
            }
            int lreturn = checkBSTLeft(root.left,root);
            int rreturn = checkBSTRight(root.right,root);
            if(lreturn==0 || rreturn==0)
                return 0;
            else
                return 1;
    }

    private static int checkBSTLeft(Node n, Node root){
        if(n==null)
            return 1;
        if(n.left!=null){
            if(!(n.left.data<n.data && n.left.data<root.data))
                return 0;
        }
        if(n.right!=null){
            if(!(n.right.data>n.data && n.right.data<root.data))
                return 0;
        }
        int l = checkBSTLeft(n.left,root);
        int r = checkBSTLeft(n.right,root);
        if(l==0 || r==0)
            return 0;
        else
            return 1;
    }

    private static int checkBSTRight(Node n, Node root){
        if(n==null)
            return 1;
        if(n.left!=null){
            if(!(n.left.data<n.data && n.left.data>root.data))
                return 0;
        }
        if(n.right!=null){
            if(!(n.right.data>n.data && n.right.data>root.data))
                return 0;
        }
        int l = checkBSTRight(n.left,root);
        int r = checkBSTRight(n.right,root);
        if(l==0 || r==0)
            return 0;
        else
            return 1;
    }
}
