package com.ds.practice.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day16Code {
    private static Node root;

    private static Node head;

    static class Node {
        int data;
        Node left,right,nextPointer;

        Node(int d){
            data=d;
            left=right=nextPointer=null;
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
            head = inOrder(root,null);
            Node n = head;
            System.out.println();
            while (n!=null){
                System.out.print(n.data+" ");
                n = n.right;
            }
            System.out.println();
            while(head.right!=null){
                head = head.right;
            }
            while (head!=null){
                System.out.println(head.data+" ");
                head = head.left;
            }
            head = null;
            root = null;
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

        private static Node inOrder(Node root,Node head){
            if(root==null)
                return head;
            head = inOrder(root.right,head);
            root.right = head;
            if(head != null)
                head.left =  root;
            head = root;
            head = inOrder(root.left,head);
            return head;
        }
}
