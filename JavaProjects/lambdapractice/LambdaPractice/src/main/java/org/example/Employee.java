package org.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {


    private int id;
    private String name;
    private String designation;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Employee() {
        super();
    }
    public Employee(int id, String name, String designation) {
        super();
        this.id = id;
        this.name = name;
        this.designation = designation;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + "]";
    }
    public  void printEmployee(){
        System.out.println(this.toString());
    }

    public static List<Employee> getListOfEmployees(){
        List<Employee> employeeList=new ArrayList<Employee>();
        Employee e1=new Employee(1,"john","tester");
        Employee e2=new Employee(2,"bhanu","dev");
        Employee e3=new Employee(3,"ramu","manager");
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        return employeeList;

    }
}
