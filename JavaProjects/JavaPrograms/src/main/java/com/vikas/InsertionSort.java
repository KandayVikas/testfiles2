package com.vikas;

public class InsertionSort {
    public static void main(String[] args) {
        int ar[]={10,30,5,50,2,1};
        int temp;
        //int i=0,j=ar.length-1;
        for (int i=1;i<=ar.length;i++){

        int key=ar[i];
        int j=i-1;
        while(j>=0 && ar[j]>key){
            ar[j+1]=ar[j];
            j=j-1;
        }
        ar[j+1]=key;
        }
    }
}
