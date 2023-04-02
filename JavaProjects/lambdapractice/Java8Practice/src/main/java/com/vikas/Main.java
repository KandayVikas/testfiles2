package com.vikas;

import java.math.BigInteger;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    static int sum(int a, int b){
        if(b>a )
            return b;
        else
            return a;
    }
    public static void main(String[] args) {
        List<String> list= Arrays.asList("John","Bhanu","Sonu");
       // list.stream().filter(l->l.length()>4).forEach(System.out::println);
        List<Integer> integerList= Arrays.asList(2,3,5,1,1);
       // System.out.println(integerList.stream().reduce(0,(a, b)->a+b));
        //In Integer class already sum method will be present so use below
        //System.out.println(integerList.stream().reduce(0,Integer::sum));
      //  System.out.println(integerList.stream().reduce(0,Main::sum ));
//        System.out.println(integerList.stream().reduce(Integer.MIN_VALUE,(x,y)->x>y?x:y));
//        System.out.println(integerList.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y));
        //square every number and find sum of numbers
       // System.out.println(integerList.stream().map(x->x*x).reduce(0,Integer::sum));
        //even sum
        //System.out.println(integerList.stream().filter(x->x%2==0).reduce(0,(x,y)->x+y));
        //distinct elements
        //integerList.stream().distinct().forEach(System.out::println);
        //sorts distinct elements descending order
       // integerList.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //sorts distinct strings in descending order based on length
        //list.stream().distinct().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        //sorts distinct strings in descending order based on alphabetical order
        //list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //collect result in a list
       // List<Integer> returnedlist= integerList.stream().filter(n->n%2==0).collect(Collectors.<Integer>toList());
        System.out.println( integerList.stream().filter(n->n%2==0).count());

        String ar[]=new String[]{"hello","hi","hello","Hi"};

       Map<Object,Long> m=Arrays.stream(ar)
                .collect(Collectors.groupingBy(s->s,Collectors.counting()));

        System.out.println(m.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).collect(Collectors.toList()));

        System.out.println(Arrays.stream(ar)
                .collect(Collectors.groupingBy(s->s,Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)));

        System.out.println(Arrays.stream(ar)
                .collect(Collectors.groupingBy(s->s,Collectors.counting()))
               .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(ms->ms.getKey()));

        Stream stream = Stream.of(1,2,3);


        stream.forEach(System.out::println);

        //Streaming through primitive int

       //will get sum from 1 to 9 without including 10
        System.out.println(IntStream.range(1,10).sum());
        //sum from 1 to 10
        System.out.println(IntStream.rangeClosed(1,10).sum());
        //peek allows to look into stream without making any changes to stream
        System.out.println(IntStream.iterate(1,e->e+2).limit(10).peek(System.out::println).sum());
                //even numbers sum from 2 to 20
        System.out.println(IntStream.iterate(2,e->e+2).limit(10).peek(System.out::println).sum());
        //sum of first 10 powers of 2
        System.out.println(IntStream.iterate(2,e->e*2).limit(10).peek(System.out::println).sum());
        //to convert into list by boxed(i.e from int to Integer) and print
        System.out.println(IntStream.iterate(2,e->e*2).limit(10).boxed().collect(Collectors.toList()));

        //Factorial of 20
        System.out.println(LongStream.rangeClosed(1,20).reduce(1,(x,y)->x*y));
        //But for Factorial of 50 it will exceed Long max value so we can use BigInteger
        System.out.println(LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply));

//        Stream.of("one", "two", "three", "four")
//                .peek(e -> System.out.println("Filtered value: " + e))
//                .filter(e -> e.length() > 3)
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .collect(Collectors.toList());
//        list.stream()
//                .filter(e -> e.length() > 4)
//                .peek(e -> System.out.println("Filtered value: " + e))
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .findFirst();

        List<String> l1=Arrays.asList("one", "two", "three", "eleven","twelve");

         l1.stream()
                 .peek(e -> System.out.println("Normal value: " + e))
                .filter(e -> e.length() > 3)
                 .peek(e -> System.out.println("filtered value: " + e))
                 .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
//output
//        Normal value: one Normal value: two Normal value: three
//        filtered value: three
//        Mapped value: THREE
//        Normal value: eleven
//        filtered value: eleven
//        Mapped value: ELEVEN
//        Normal value: twelve
//        filtered value: twelve
//        Mapped value: TWELVE

//        l1.stream()
//                .peek(e -> System.out.println("Normal value: " + e))
//                .filter(e -> e.length() > 3)
//                .peek(e -> System.out.println("filtered value: " + e))
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .findFirst();

        //output Normal value: one
        //Normal value: two
        //Normal value: three
        //filtered value: three
        //Mapped value: THREE

          long t=System.currentTimeMillis();
        //System.out.println(LongStream.rangeClosed(1,1000000000).sum()); //395 millisecs
        System.out.println(LongStream.rangeClosed(1,1000000000).parallel().sum()); //128 millisecs

        System.out.println(System.currentTimeMillis()-t);
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.stream().parallel().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );










    }
}