package com.vikas;

import java.util.Arrays;

/*Bubble sort works on the repeatedly swapping of adjacent elements until they are not in the
        intended order. It is called bubble sort because the movement of array elements is just
        like the movement of air bubbles in the water. Bubbles in water rise up to the surface;
similarly, the array elements in bubble sort move to the end in each iteration.

        the performance of bubble sort is poor in the real world.
        The average and worst-case complexity of Bubble sort is O(n2), where n is a number of items.*/
public class BubbleSort {
    public static void main(String[] args) {
        int ar[]={20,30,10,50,5};
        int temp;
        for (int i=0;i<ar.length-1;i++){
            for(int j=i+1;j<=ar.length-1;j++) {
                if (ar[i] > ar[j]) {
                    temp = ar[j];
                    ar[j] = ar[i];
                    ar[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ar));
    }
}
