package com.vikas;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(checkForStringPalindrome("madam"));
        System.out.println(checkForIntegerPalindrome(101));
    }


    private static boolean checkForStringPalindrome(String input) {
//        String s="";
//       for(int i=input.length();i>0;i--){
//           s=s+input.charAt(i-1);
//       }
//       if(s.equals(input))
//           return true;
//       else
//           return false;
     String i=input;
       StringBuffer sb=new StringBuffer(input);
       sb=sb.reverse();

       if(sb.toString().equals(i)){
           return true;
       }
       else
           return false;
    }

    private static boolean checkForIntegerPalindrome(int i) {
        String n=i+"";
        String s="";
        while(i>0){

            s=s+i%10;
            i=i/10;
        }

        if(s.equals(n))
            return true;
        else
            return false;
    }
}
