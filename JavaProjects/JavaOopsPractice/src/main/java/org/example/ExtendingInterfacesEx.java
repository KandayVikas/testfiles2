package org.example;


interface Ex1{
    void add();
}
interface Ex2 extends Ex1{
    void add(int a,int b);
}
public class ExtendingInterfacesEx implements Ex2 {

    @Override
    public void add(int a, int b) {

    }

    @Override
    public void add() {

    }
}
