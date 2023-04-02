package com.vikas;

import static java.util.Objects.isNull;

interface DefaultStaticExampleInterface1 {
    //1) Now when a class will implement Interface1,It is not mandatory
    // to provide implementation for default methods of interface
    //2) But if a class implement 2 interfaces and same default method is present in both interfaces
    // then class should provide implementation of that method as compiler won't understand which one to pick
    default void show() {
        System.out.println("In Java 8- default method - DefaultStaticExampleInterface");
    }
    default void show1() {
        System.out.println("In Java 8- default method - DefaultStaticExampleInterface");
    }
   // void show2(); //abstract method which don't have any body
    //abstract methods should be mandatory to override in class but its not required for defualt methods
    static void display() {
        System.out.println("In DefaultStaticExampleInterface I");
    }
}

interface DefaultStaticExampleInterface2{
    default void show1() {
        System.out.println("In Java 8- default method - DefaultStaticExampleInterface");
    }
// Here above as both interfaces have same method diamond problem will arise bcz compiler can’t decide which one to chose.
//So to make sure, this problem won’t occur in interfaces, it’s made mandatory to provide implementation
// for common default methods of interfaces. If not compiler error will occur
}
public class DefaultStaticExampleClass implements DefaultStaticExampleInterface1,DefaultStaticExampleInterface2{

    @Override
    public void show1() {
        DefaultStaticExampleInterface1.super.show1();
    }

    static void display() {
        System.out.println("In DefaultStaticExampleInterface I");
    }
    public static void main(String[] args) {
        // Call interface static method on Interface
        DefaultStaticExampleInterface1.display();
        DefaultStaticExampleClass defaultStaticExampleClass = new DefaultStaticExampleClass();

        // Call default method on Class
        defaultStaticExampleClass.show();

        DefaultStaticExampleClass.display();
        //To resolve diamond problem
        defaultStaticExampleClass.show1();

    }



}
