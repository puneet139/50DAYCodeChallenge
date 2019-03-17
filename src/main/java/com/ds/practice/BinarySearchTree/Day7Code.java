package com.ds.practice.BinarySearchTree;

import java.util.*;

public class Day7Code {

    private static Node root;

    static class Node{
        int value;
        Node left;
        Node right;
        Node parent;
        int level;

        Node(int val, Node l,Node r,Node p){
            value=val;
            left=l;
            right=r;
            parent=p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to insert");
        int number = sc.nextInt();
        boolean exit = false;
        root = new Node(number,null,null,null);
        while(!exit)
        {
            System.out.println("Would you like to continue y/n");
            if("n".equalsIgnoreCase(sc.next()))
            {
                exit=true;
                break;
            }
            System.out.println("Enter the element to insert");
            number = sc.nextInt();
            insert(number);
        }
        //printTree(root);
        leftView(root);
    }

    private static void insert(int number){
        root = insertUtil(number,root,null);
    }

    private static Node insertUtil(int number,Node root,Node parent){
        if(root==null){
            Node newNode = new Node(number,null,null,parent);
            return newNode;
        }else if(number<root.value){
            root.left = insertUtil(number,root.left,root);
        }else if(number>root.value){
            root.right = insertUtil(number,root.right,root);
        }
        return root;
    }

    private static void leftView(Node root){
        Queue<Node> q=new LinkedList<Node>();
        Queue<Integer> level=new LinkedList<Integer>();
        Node temp=root;
        int temp_level=0;
        System.out.print(root.value+" ");
        while(temp!=null){
            if(temp.left!=null){
                q.add(temp.left);
                level.add(temp_level+1);
            }
            if(temp.right!=null){
                q.add(temp.right);
                level.add(temp_level+1);
            }
            if(level.peek()!=null && temp_level!=level.peek()){
                System.out.print(q.peek().value+" ");
            }
            temp=q.poll();
            if(level.peek()!=null)
                temp_level=level.poll();

        }
    }
}

