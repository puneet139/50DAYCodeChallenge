package com.ds.practice.BinarySearchTree;

import java.util.*;

public class Day13Code {

    private static Node root;

    private static Map<Integer,Queue<Node>> m = new TreeMap<Integer,Queue<Node>>();

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
        for(int i=0;i<numTestCases;i++){
            int numEdges = sc.nextInt();
            for(int j=0;j<numEdges;j++){
                int firstNode = sc.nextInt();
                int secondNode = sc.nextInt();
                String flag = sc.next();
                Node n = searchNode(firstNode);
                insertInTree(n,secondNode,flag);
            }
            Queue<Node> n = new LinkedList<Node>();
            n.add(root);
            m.put(0,n);
            connect(root);
            printSpecial(root);
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

    private static void connect(Node root){
        int height = checkHeight(root);
        int level = 0;
        Map<Integer,Queue<Node>> m = new TreeMap<Integer,Queue<Node>>();
        Queue<Node> newQueue = new LinkedList<Node>();
        Queue<Node> q1;
        newQueue.add(root);
        m.put(0,newQueue);
        while(level<=height){
            if(m.get(level)!=null){
                Queue<Node> q = m.get(level);
                while(!q.isEmpty()){
                    Node r = q.poll();
                    r.nextPointer=q.peek();
                    if(m.get(level+1)!=null){
                        q1 = m.get(level+1);
                    }else{
                        q1 = new LinkedList<Node>();
                    }
                    if(r.left!=null){
                        q1.add(r.left);
                    }
                    if(r.right!=null)
                        q1.add(r.right);
                    m.put(level+1,q1);
                }
                level = level+1;
        }
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

    private static void printSpecial(Node root){
        if(root==null)
            return;
        Node n = root;
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.nextPointer;
        }
        if(root.left!=null)
            printSpecial(root.left);
        else{
            printSpecial(root.right);
        }
    }


}
