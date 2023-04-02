package com.vikas;

public class BinarySearch {

    public static void main(String[] args) {
// Binary search is done in sorted array. If array is not sorted then sort array by Arrays.sort(arr)
//        Time Complexity: O(log N)
//        Auxiliary Space: O(log N)
        int ar[] = {10, 20, 30, 40, 50};
        int last = ar.length - 1;
        int key = 40;
        int res = binarySearchKey(ar, 0, last, key);
        System.out.println(res);
    }

    private static int binarySearchKey(int[] ar, int first, int last, int key) {

        int mid = (first + last) / 2;
        while (first <= last) {
            if (ar[mid] == key) {
                return mid;
            } else if (key > ar[mid]) {
                first = mid + 1;
            } else if(key < ar[mid]) {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return -1;
    }

}
