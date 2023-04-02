package com.vikas;

import java.util.stream.IntStream;

public class FPWithThreads {

    public static void main(String[] args) {
        //Threads
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println(Thread.currentThread().getId()+":"+i);
                }
            }
        };
        //Thread with lambda as runnable is also a functional interface
        Runnable runnable1=() -> {
            for(int i=0;i<1000;i++){
                System.out.println(Thread.currentThread().getId()+":"+i);
            }
        };
        Runnable runnable2=
                () -> IntStream.rangeClosed(0,1000).forEach(i->System.out.println(Thread.currentThread().getId()+":"+i));



        Thread thread1=new Thread(runnable2);
        thread1.start();

        Thread thread2=new Thread(runnable2);
        thread2.start();
    }
}
