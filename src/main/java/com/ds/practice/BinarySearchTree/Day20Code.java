package com.ds.practice.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day20Code {

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
            System.out.println(diameter(root));
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

    private static int diameter(Node root){
        Res r = new Res();
        diameterUtility(root,r);
        return r.res;
    }

    private static int diameterUtility(Node node,Res r){
        if(node==null)
            return r.res;
        if(node.left==null && node.right==null){
            return 1;
        }
        int lheight = diameterUtility(node.left,r);
        int rheight = diameterUtility(node.right,r);
        if(lheight>rheight)
            lheight = lheight+1;
        else
            rheight = rheight+1;
        if(node.left!=null && node.right!=null)
        {
            r.res = Math.max(r.res,lheight+rheight);
            return Math.max(lheight,rheight);
        }

        return (node.left==null) ? rheight : lheight;
    }

}
