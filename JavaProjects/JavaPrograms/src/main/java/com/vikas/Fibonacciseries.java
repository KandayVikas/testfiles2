package com.vikas;

public class Fibonacciseries {

    public static void main(String[] args) {
        fibonacciWithoutRecursion();

        int n=5;
        int a=0,b=1;
        System.out.print(a+" "+b);
        for(int i=0;i<n-2;i++){

            int temp=fibonacciWithRecursion(a,b);
            System.out.print(" "+temp);
            a=b;
            b=temp;

        }
    }

    public static void fibonacciWithoutRecursion(){
        //0 1 1 2 3 5 8

        int n=7;
        int a=0,b=1;
        System.out.print(a+" "+b);
        for(int i=0;i<n-2;i++){
            int c=a+b;
            a=b;
            b=c;
            System.out.print(" "+c);
        }
    }

    public static int fibonacciWithRecursion(int a, int b){
        //0 1 1 2 3 5 8
        return a+b;
    }
}
