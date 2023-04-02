package org.example;


class A{
    //If we uncomment this B needs to implement this in that class
    // a parameterized constructor
//    A(int a, int b){
//
//    }

    void display(){
        System.out.println("In class A");
    }
}
class B extends A{


    void display(){
        System.out.println("In class B");
    }
}
public class TightCouplingEx {
    public static void main(String[] args) {
B obj =new B();
obj.display();
    }
}
