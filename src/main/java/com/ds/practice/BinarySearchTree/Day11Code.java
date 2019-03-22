package com.ds.practice.BinarySearchTree;

import java.util.Scanner;

public class Day11Code {

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
        int numTestCases = sc.nextInt();
        for(int i=0;i<numTestCases;i++){
            int numEdges = sc.nextInt();
            for(int j=0;j<numEdges;j++){
                int firstNode = sc.nextInt();
                int secondNode = sc.nextInt();
                String flag = sc.next();
                Node n = searchNode(firstNode);
                insertInTree(n,secondNode,flag);
            }
            System.out.println(isBalanced(root));
        }
    }

    private static Node searchNode(int firstNode){
        if(root==null)
            return (root=new Node(firstNode));
        else if(root.data==firstNode)
            return root;
        else
            return searchNodeUtil(root,firstNode);
    }

    private static Node searchNodeUtil(Node root,int firstNode){
        if(root.left!=null){
            if(root.left.data==firstNode)
                return root.left;
            else
                return searchNodeUtil(root.left,firstNode);
        }
        if(root.right!=null){
            if(root.right.data==firstNode)
                return root.right;
            else
                return searchNodeUtil(root.right,firstNode);
        }
        return root;
    }

    private static void insertInTree(Node n,int secondNode,String flag){
        if("L".equals(flag)){
            Node newNode = new Node(secondNode);
            n.left=newNode;
        }else if("R".equals(flag)){
            Node newNode = new Node(secondNode);
            n.right=newNode;
        }
    }

    private static boolean isBalanced(Node root){
        if(root==null || (root.left==null && root.right==null))
            return true;
        else{
            int leftHeight = checkHeight(root.left);
            int rightHeight = checkHeight(root.right);
            if(Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) && isBalanced(root.right))
                return true;
            else
                return false;
        }
    }

    private static int checkHeight(Node root){
        if(root==null)
            return 0;
        else{
            int lheight = checkHeight(root.left);
            int rheight = checkHeight(root.right);
            if(lheight>rheight)
                return lheight+1;
            else
                return rheight+1;
        }
    }

}
