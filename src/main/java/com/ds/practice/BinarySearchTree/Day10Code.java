package com.ds.practice.BinarySearchTree;

import java.util.Scanner;

public class Day10Code {

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
            System.out.println(countLeaves(root));
        }
    }

    private static Node searchNode(int firstNode){
        if(root==null)
            return (root=new Node(firstNode));
        else if(root.data==firstNode)
            return  root;
        else return searchNodeUtil(root,firstNode);
    }

    private static Node searchNodeUtil(Node root,int firstNode){
        if(root.left!=null){
            if(root.left.data==firstNode){
                return root.left;
            }else
                root.left=searchNodeUtil(root.left,firstNode);
        }
        if(root.right!=null){
            if(root.right.data==firstNode){
                return root.right;
            }else{
                root.right= searchNodeUtil(root.right,firstNode);
            }
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

    private static int countLeaves(Node root){
        if(root==null)
            return 0;
        else if(root.left==null && root.right==null){
            return 1;
        }else{
            return countLeavesUtil(root,0);
        }
    }

    private static int countLeavesUtil(Node root,int count){
        if(root==null)
            return count;
        if(root.left==null && root.right==null)
            return count + 1;
        else{
            count = countLeavesUtil(root.left,count);
            count = countLeavesUtil(root.right,count);
        }
        return count;
    }
}
