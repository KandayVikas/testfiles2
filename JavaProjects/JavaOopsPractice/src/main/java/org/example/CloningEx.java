package org.example;


class Student implements Cloneable {

 String name;
  Address address;

    protected Object clone() throws CloneNotSupportedException
    {
        Student student= (Student) super.clone();
        student.address= (Address) address.clone();

        return student;
    }

    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address implements Cloneable{
    String name;
    String landmark;

    public Address(String name, String landmark) {
        this.name = name;
        this.landmark = landmark;
    }

    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

public class CloningEx {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address=new Address("vikas","new town colony");

        Student student=new Student("Vikas",address);

//        student.setName("john");
        Student cloningStudent= null;
        cloningStudent=(Student) student.clone();
        cloningStudent.address.name="john";

        System.out.println(student.address.name);
        System.out.println(cloningStudent.address.name);

    }
}
