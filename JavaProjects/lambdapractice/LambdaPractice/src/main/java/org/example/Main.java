package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface ToTest{
    void test();
}

@FunctionalInterface
interface CheckEmployee{
    boolean test(Employee e);
}
    
public class Main {



    public static List<Employee>  sortEmployeesBasedOnName(){
        List<Employee> employees=Employee.getListOfEmployees();
        Collections.sort(employees,new MyComparator());
        return employees;
    }

    private static  List<Employee>  sortEmployeesBasedOnNameByAnonymous() {
        List<Employee> employees=Employee.getListOfEmployees();
        Collections.sort(employees,new MyComparator(){
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        );
        return employees;
    }

    private static  List<Employee>  sortEmployeesBasedOnNameByLambdaFn() {
        List<Employee> employees=Employee.getListOfEmployees();
        Collections.sort(employees, (o1,o2) -> o1.getName().compareTo(o2.getName()));
        return employees;
    }
    public static void printEmployee(List<Employee> employees,
                                   CheckEmployee tester) {
        for(Employee e: employees) {
            if(tester.test(e)) {
               // e.printEmployee();
                System.out.println(e);
            }
        }
    }
    public static void printPeopleWithPredicate(List<Employee> employee,
                                                Predicate<Employee> tester) {
        for(Employee e: employee) {
            if(tester.test(e)) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

//Ex1
//        ToTest toTest= () -> {
//            System.out.println("Hello");
//        };
//        toTest.test();

       // Ex2 (By existing functional interface Comparator)
        //normal traditional way
        //System.out.println(sortEmployeesBasedOnName());
        //By anonymous class way
        //System.out.println(sortEmployeesBasedOnNameByAnonymous());
        //By Lambda Function
        //System.out.println(sortEmployeesBasedOnNameByLambdaFn());


        //Ex3 (By custom functional interface)
        //List<Employee> employees=Employee.getListOfEmployees();
        //normal way
        //getEmployeesGreaterThanId(employees,1);
        //by lambda function
     //  printEmployee(employees,(e)->e.getId()>1 );
        //lamda function by existing Predicate fn interface
       // printPeopleWithPredicate(employees,(e)->e.getId()>1 );

    }



    private static void getEmployeesGreaterThanId(List<Employee> employees,int id) {
       // List<Employee> employees=new ArrayList<>()
        for(Employee e:employees){
            if(e.getId()>id){
                System.out.println(e.toString());
           // e.printEmployee();
            }
        }
    }
}
class MyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}