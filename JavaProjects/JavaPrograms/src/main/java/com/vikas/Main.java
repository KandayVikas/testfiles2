package com.vikas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        array();
      //  palindrome();
    }

    private static void array() {

        int arr[]=new int[7];
        System.out.println(arr[0]);
    }

    private static void palindrome() {
//        A prime number is a number that is divisible by only two numbers: 1 and itself.
//        So, if any number is divisible by any other number, it is not a prime number.
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        //Method 1
      /*  StringBuffer sb=new StringBuffer(input);
        sb.reverse();
        if(input.equals(sb.toString())){
            System.out.println("palindrome");
        }
        else {
            System.out.println("no"+input+" "+sb);
        }
        //Method 2
        String op="";
        for(int i=input.length()-1;i>=0;i--){
            op=op+input.charAt(i);
        }
        if(input.equals(op)){
            System.out.println("palindrome");
        }*/
        //Method 3 by recursion
        if(ispalindrome(input))
            System.out.println("palindrome");
        else
            System.out.println("no");
    }

    private static boolean ispalindrome(String input) {
        if (input.length() == 0 || input.length() == 1)
            return true;
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            System.out.println(input.substring(1, input.length() - 1));
            return ispalindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }
}