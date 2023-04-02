package com.vikas;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        //For matrix multiplication, the number of columns in the first matrix
        // must be equal to the number of rows in the second matrix.
                Scanner scanner=new Scanner(System.in);
        System.out.println("enter rows of first matrix");
        int a= scanner.nextInt();
        System.out.println("enter cols of first matrix");
        int b= scanner.nextInt();
        int ar1[][]=new int[a][b];
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++) {
                System.out.printf("Enter a[%d][%d]:",i,j);
                ar1[i][j]= scanner.nextInt();
            }
        }


        System.out.println("enter rows of second matrix");
        int c=scanner.nextInt();
        System.out.println("enter cols of second matrix");
        int d= scanner.nextInt();
        if(b!=c){
            System.out.println("matrix mult is not posb as cond is not met");
            System.exit(0);
        }
        System.out.println("enter rows of 2nd matrix");
        int ar2[][]=new int[c][d];
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++) {
                System.out.printf("Enter a[%d][%d]:",i,j);
                ar2[i][j]= scanner.nextInt();
            }
        }

        int res[][]=new int[b][c];
        for (int i=0;i<b;i++){
            for (int j=0;j<c;j++) {
                //System.out.printf("Enter a[%d][%d]:",a,b);
                res[i][j]=ar1[i][j]*ar2[i][j];
                System.out.printf("res[%d][%d]: %d ",i,j, res[i][j]);
            }
            System.out.println();
        }

    }
}
