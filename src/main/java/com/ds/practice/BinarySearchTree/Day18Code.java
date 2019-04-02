package com.ds.practice.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day18Code {
    private static Node root;

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
                Node n = searchNode(firstNode);
                insertInTree(n, secondNode, flag);
            }
            System.out.println(isSymmetrical(root));
        }
    }

    private static Node searchNode(int firstNode){
        if(root==null)
            return (root=new Node(firstNode));
        if(root.data==firstNode)
            return root;
        else{
            return searchNodeUtil(root,firstNode);
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

    private static boolean isSymmetrical(Node root){
        return isMirror(root,root);
    }

    private static boolean isMirror(Node root1, Node root2){
        if(root1==null && root2==null)
            return true;
        if(root1!=null && root2!=null && root1.data==root2.data)
            return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);

        return false;
    }
}
