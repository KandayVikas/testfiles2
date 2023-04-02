package com.vikas;

import java.util.Scanner;

public class TransposeMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter rows of matrix");
        int a=scanner.nextInt();
        System.out.println("Enter cols of matrix");
        int b=scanner.nextInt();
        int ar[][]=new int[a][b];
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){

                System.out.printf("Enter ar[%d][%d]: ",i,j);
                ar[i][j]= scanner.nextInt();
            }
            System.out.println();
        }
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                System.out.printf("ar[%d][%d]: %d ",i,j,ar[j][i]);
            }
            System.out.println();
        }

    }
}
