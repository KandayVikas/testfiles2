package com.vikas;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println(checkArmstrong(1634));
    }

    private static boolean checkArmstrong(int num) {
       String s=num+"";
        System.out.println(s);
       double op=0;
       for(int i=0;i<s.length();i++){
           op=op+(Math.pow(Integer.parseInt(s.charAt(i)+""),s.length()));
           System.out.println(op);
       }
        System.out.println(op);
       if(op==num)
           return true;
       else
           return false;
    }
}
