package com.ds.practice.BinarySearchTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyQueue {

    private int front=0;
    private int rear = 0;

    private List<Integer> arr = new LinkedList<Integer>();

    public void insert(int num){
        if(!this.isFull()){
            arr.add(rear,num);
            ++rear;
        }
    }

    public int remove(){
        if(!this.isEmpty()){
            int num = arr.get(front);
            ++front;
            return num;
        }
        return -1;
    }

    public boolean isFull(){
        if(rear==arr.size()-1)
            return true;
        else
            return false;
    }

    public boolean isEmpty(){
        if(rear==front)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue queue = new MyQueue();
        System.out.println("Enter the number of elements to be inserted");
        int numelements = sc.nextInt();
        for (int i = 0; i < numelements; i++) {
            if (!queue.isFull()) {
                queue.insert(sc.nextInt());
            }
        }
        if (!queue.isEmpty()) {
            queue.remove();
        }
        for(int i=queue.front;i<queue.rear;i++)
            System.out.println(queue.arr.get(i));
    }
}
