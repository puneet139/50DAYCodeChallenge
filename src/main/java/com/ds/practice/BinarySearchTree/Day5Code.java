package com.ds.practice.BinarySearchTree;

import java.util.Scanner;

public class Day5Code {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers whose GCD needs to be found out");
        Integer firstNumber = sc.nextInt();
        Integer secondNumber = sc.nextInt();
        if(firstNumber!=null && secondNumber!=null){
            int gcd = calculateGCD(firstNumber,secondNumber);
            System.out.println("The GCD is :"+gcd);
        }
    }

    private static int calculateGCD(int first,int second){
        if(second==0)
            return first;
        else
            return calculateGCD(second,first%second);
    }
}
