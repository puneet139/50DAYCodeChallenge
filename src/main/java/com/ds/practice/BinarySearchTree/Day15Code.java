package com.ds.practice.BinarySearchTree;

import java.util.*;

public class Day15Code {

    private static Node root;

    private static Map<Integer,Integer> nodesMap = new TreeMap<Integer, Integer>();

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
            int firstNodeData = sc.nextInt();
            int secondNodeData = sc.nextInt();
            System.out.println(lca(root,firstNodeData,secondNodeData));
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

    private static Integer lca(Node root,int n1,int n2){
        populateMap(root,null);
        List<Integer> parentList = new ArrayList<Integer>();
        int parent1 = nodesMap.get(n1);
        int parent2 = nodesMap.get(n2);
        if(n1==root.data || n2==root.data)
            return root.data;
        if(parent1!=-1 && (parent1==n2))
            return parent1;
        if(parent2!=-1 && (parent2==n1))
            return parent2;
        while(parent1!=-1 && nodesMap.get(parent1)!=-1){
            parentList.add(nodesMap.get(parent1));
            parent1 = nodesMap.get(parent1);
        }
        while(parent2!=-1 && nodesMap.get(parent2)!=-1){
            if(parentList.contains(nodesMap.get(parent2)) || parent1==nodesMap.get(parent2)){
                return nodesMap.get(parent2);
            }
            parent2 = nodesMap.get(parent2);
        }
        return -1;
    }

    private static void populateMap(Node n,Node parent){
        if(n==null)
            return;
        if(parent==null)
            nodesMap.put(n.data,-1);
        else
            nodesMap.put(n.data,parent.data);
        populateMap(n.left,n);
        populateMap(n.right,n);
    }
}
