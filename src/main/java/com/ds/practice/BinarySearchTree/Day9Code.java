package com.ds.practice.BinarySearchTree;

import java.util.*;

public class Day9Code {

    private static Node root;

    static class Node {
        int data;
        Node left,right=null;

        Node(int d){
            data=d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i=0;i<numTestCases;i++){
            int numEdges = sc.nextInt();
            for(int j=0;j<numEdges;j++){
                int firstNode = sc.nextInt();
                int seconNode = sc.nextInt();
                String flag = sc.next();
                Node n= searchNode(firstNode);
                insertInTree(n,seconNode,flag);
            }
        }
        verticalOrder(root);
    }

    private static Node searchNode(int firstNode){
        if(root==null)
            return (root=new Node(firstNode));
        else if(root.data==firstNode)
            return root;
        else {
            Node n = searchNodeUtil(root,firstNode);
            return n;
        }
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

    private static void insertInTree(Node n,int secondNode, String flag){
        if("L".equals(flag)){
            Node newNode = new Node(secondNode);
            n.left=newNode;
        }else if("R".equals(flag)){
            Node newNode = new Node(secondNode);
            n.right=newNode;
        }
    }

    private static void verticalOrder(Node root){
        if(root==null)
            return;
        TreeMap<Integer,LinkedList<Node>> nodeMap = new TreeMap<Integer, LinkedList<Node>>();
        getVerticalOrderEntry(root,nodeMap,0);
        Set<Map.Entry<Integer,LinkedList<Node>>> entries = nodeMap.entrySet();
        for(Map.Entry<Integer,LinkedList<Node>> entry : entries){
            for(Node n:entry.getValue()){
                System.out.print(n.data+" ");
            }
        }
    }

    private static void getVerticalOrderEntry(Node root,TreeMap<Integer,LinkedList<Node>> nodeMap, int hd){
        if(root==null)
            return;
        if(nodeMap.get(hd)==null){
            LinkedList<Node> ln = new LinkedList<Node>();
            ln.add(root);
            nodeMap.put(hd,ln);
        }else{
            LinkedList<Node> existng = nodeMap.get(hd);
            existng.add(root);
            nodeMap.put(hd,existng);
        }
        getVerticalOrderEntry(root.left,nodeMap,hd-1);
        getVerticalOrderEntry(root.right,nodeMap,hd+1);
    }
}
