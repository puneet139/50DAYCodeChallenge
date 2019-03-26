package com.ds.practice.BinarySearchTree;

import java.util.*;

public class Day14Code {

    private static Node root;

    private static List<Integer> list = new ArrayList<Integer>();

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
            String s = serialize(root,list);
            Node r1 = deserialize(s);
            inorder(r1);
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

    private static String serialize(Node root,List<Integer> list){
        int i=0;
        Queue<Node> q = new LinkedList<Node>();
        StringBuffer sb = new StringBuffer();
        q.add(root);
        while(!q.isEmpty()){
            Node r = q.poll();
            list.add(i,r.data);
            sb.append(r.data+" ");
            if(r.left!=null){
                list.add(2*i+1,r.left.data);
            }
            if(r.right!=null){
                list.add(2*i+2,r.right.data);
            }
            i = i+1;
        }
        return sb.toString();
    }

    private static Node deserialize(String s){
        if(s==null)
            return null;
        String[] arr = s.split(" ");
        Node root = searchNode(Integer.parseInt(arr[0]));
        Node n = root;
        for(int i=0;i<arr.length/2;i++){
            n = searchNode(Integer.parseInt(arr[i]));
            n.left = searchNode(Integer.parseInt(arr[2*i+1]));
            n.right = searchNode(Integer.parseInt(arr[2*i+2]));
        }
        return root;
    }

    private static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

}

