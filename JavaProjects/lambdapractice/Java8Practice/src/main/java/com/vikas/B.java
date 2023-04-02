package com.vikas;

public interface B {

   default void m(){
        System.out.println("hi");
    }
    void m1();
   static void m2(){
       System.out.println("static method");
   }

}
