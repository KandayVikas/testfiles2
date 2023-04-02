package org.example;

interface Parent{
    void foo();

}
class AB implements Parent{
    // parameterized constructor
    AB(int x, int y)
    {

    }

    @Override
    public void foo() {

    }
}
class BC implements Parent{

    @Override
    public void foo() {

    }
}
public class LooseCouplingEx {
}
