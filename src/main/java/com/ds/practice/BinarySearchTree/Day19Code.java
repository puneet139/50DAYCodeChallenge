package com.ds.practice.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day19Code {

    private static Node root;

    static class Node {
        int data;
        Node left,right;

        Node(int d){
            data=d;
            left=right=null;
        }
    }

    static class Res{
        int res;
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
        System.out.println(maxPathSum(root));
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

    public static int maxPathSum(Node root)
    {
        Res r = new Res();
        maxPathSumUtility(root,r);
        return r.res;
    }

    private static int maxPathSumUtility(Node node,Res r){
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return node.data;
        int ls = maxPathSumUtility(node.left,r);
        int rs = maxPathSumUtility(node.right,r);
        if(node.left!=null && node.right!=null){
            r.res = Math.max(r.res,ls+rs+node.data);
            return Math.max(ls,rs)+ node.data;
        }
       return  (node.left==null) ? rs + node.data : ls + node.data;
    }
}
