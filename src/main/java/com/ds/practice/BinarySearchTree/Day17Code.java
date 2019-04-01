package com.ds.practice.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day17Code {

    private static Node root;

    private static Node root1;

    static class Node {
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
        for(int i=0;i<numTestCases;i++) {
            int numEdges = sc.nextInt();
            for (int j = 0; j < numEdges; j++) {
                int firstNode = sc.nextInt();
                int secondNode = sc.nextInt();
                String flag = sc.next();
                Node n = searchNodeFirst(firstNode);
                insertInTree(n, secondNode, flag);
            }
            int secondTreeNumEdges = sc.nextInt();
            for (int j = 0; j < secondTreeNumEdges; j++) {
                int firstNode = sc.nextInt();
                int secondNode = sc.nextInt();
                String flag = sc.next();
                Node n = searchNodeSecond(firstNode);
                insertInTree(n, secondNode, flag);
            }
            System.out.println(isIdentical(root,root1));
        }
    }

    private static Node searchNodeFirst(int firstNode){
        if(root==null)
            return (root=new Node(firstNode));
        if(root.data==firstNode)
            return root;
        else{
            return searchNodeUtil(root,firstNode);
        }
    }

    private static Node searchNodeSecond(int firstNode){
        if(root1==null)
            return (root1=new Node(firstNode));
        if(root1.data==firstNode)
            return root1;
        else{
            return searchNodeUtil(root1,firstNode);
        }
    }

    private static Node searchNodeUtil(Node root, int firstNode){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node r = q.poll();
            if(r.data==firstNode)
                return r;
            else{
                if(r.left!=null)
                    q.add(r.left);
                if(r.right!=null)
                    q.add(r.right);
            }
        }
        return null;
    }

    private static void insertInTree(Node n,int secondNode, String flag){
        if("L".equals(flag)){
            Node newNode = new Node(secondNode);
            n.left=newNode;
        }else if("R".equals(flag)){
            Node newNode = new Node(secondNode);
            n.right=newNode;
        }
    }

    private static boolean isIdentical(Node root,Node root1){
        if(root==null && root1==null)
            return true;
        else if((root==null && root1!=null) || (root1==null && root!=null))
            return false;
        else{
            if(root.data==root1.data)
                return isIdentical(root.left,root1.left) && isIdentical(root.right,root1.right);
            else{
                return false;
            }
        }
    }

}
