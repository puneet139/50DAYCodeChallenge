package com.ds.practice.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Day12Code {
        private static Node root;

        private static Stack<Node> queueNode = new Stack<Node>();

        private static Stack<Node> stackNodes = new Stack<Node>();

        private static int i=0;

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
                stackNodes.add(root);
                printSpiral(root);
            }
        }

        private static Node searchNode(int firstNode){
            if(root==null)
                return (root=new Node(firstNode));
            else if(root.data==firstNode)
                return root;
            else
                return searchNodeUtil(root,firstNode);
        }

        private static Node searchNodeUtil(Node n,int firstNode){

            // Base Case
            if (root == null)
                return null;

            // Create an empty stack and push root to it
            Stack<Node> nodeStack = new Stack<Node>();
            nodeStack.push(root);

            // Do iterative preorder traversal to search x
            while (!nodeStack.isEmpty())
            {
                // See the top item from stack and check if it is same as x
                Node node = nodeStack.peek();
                if (node.data == firstNode)
                    return node;
                nodeStack.pop();

                // Push right and left children of the popped node to stack
                if (node.right!=null)
                    nodeStack.push(node.right);
                if (node.left!=null)
                    nodeStack.push(node.left);
            }

            return n;
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

        private static void printSpiral(Node node){
            int height = checkHeight(root);
            while(i<height){
                if(i%2==0){
                    printStackNodes();
                }else{
                    printQueueNodes();
                }
                ++i;
            }
        }

        private static void printStackNodes(){
            while(!stackNodes.isEmpty()){
                Node n = stackNodes.pop();
                System.out.print(n.data+" ");
                if(n.right!=null){
                    queueNode.add(n.right);
                }
                if(n.left!=null){
                    queueNode.add(n.left);
                }
            }
        }

        private static void printQueueNodes(){
            while(!queueNode.isEmpty()){
                Node n = queueNode.pop();
                System.out.print(n.data+" ");
                if(n.left!=null){
                    stackNodes.add(n.left);
                }
                if(n.right!=null){
                    stackNodes.add(n.right);
                }
            }
        }
}
