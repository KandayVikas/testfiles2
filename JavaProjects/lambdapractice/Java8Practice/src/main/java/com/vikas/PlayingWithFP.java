package com.vikas;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayingWithFP {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Spring", "Java", "Aws", "Sql");


        list.replaceAll(s -> s.toUpperCase());

        System.out.println(list);
        List<String> l1 = new ArrayList<>(list);
        l1.removeIf(s -> s.length() < 4);
        System.out.println(l1);

        List<String> list1 = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");

        // Using Stream flatMap(Function mapper)
        list1.stream().map(str -> str.charAt(2)).forEach(System.out::println);

        //List to String
        System.out.println(list1.stream().collect(Collectors.joining(" ")));

        System.out.println(list1.stream().collect(Collectors.joining(",")));

        //split chars from all elements in list
        //when we split here it returns stream of string arrays
        //[["G","e","e","k","s"]["G","F","g"].....]
        //but we need all together so flat map converts stream of string arrays to single stream
        //Stream ["G","e","e","k","s","G","F","g",.......]
        list1.stream().map(course->course.split("")).flatMap(Arrays::stream).forEach(x->System.out.print(x+" "));

        //distinct chars
        list1.stream().map(course->course.split("")).flatMap(Arrays::stream).distinct().forEach(x->System.out.print(x+" "));
        System.out.println();

        List<String> list2 = Arrays.asList("Spring", "Spring Boot", "API", "Aws","Cloud","PCF","Azure","C","Python","Java","Sql");
        List<String> list3 = new ArrayList<>(list2);

        //All Tuples from list
        list2.stream().flatMap(course2->list3.stream().map(course3->Arrays.asList(course2,course3))).forEach(System.out::print);
          //[Spring, Spring][Spring, Spring Boot][Spring, API][Spring, Aws]......
        //[Spring Boot, Spring][Spring Boot, Spring Boot][Spring Boot, API].....etc
        System.out.println();
        //Tuples with same length in list
        list2.stream().flatMap(course2->list3.stream().filter(course3->course2.length()==course3.length()).map(course3->Arrays.asList(course2,course3))).forEach(System.out::print);
        System.out.println();
        //Tuples with same length in list without same elements in one list
        list2.stream().flatMap(course2->list3.stream().filter(course3->course2.length()==course3.length() && course2!=course3).map(course3->Arrays.asList(course2,course3))).forEach(System.out::print);

        //List to array
        Object ar[]=list2.stream().toArray();

        //we can create streams in this way also
        Stream<String> stream = Stream.of("Geeks", "for", "Geeks", "GeeksQuiz");
        Stream<Integer> stream1 = Stream.of(1,2);

        System.out.println();
        //List to Map
        System.out.println(list2.stream().collect(Collectors.toMap(s -> s, String::length)));
        //List to Map with how many repeatations
        System.out.println(list2.stream().collect(Collectors.groupingBy(s->s,Collectors.counting())));

        int arr[]={1,2,3,4,5};

        //int to double stream
        Arrays.stream(arr).asDoubleStream().forEach(x->System.out.print(x+" "));
        System.out.println();

        //array and collect result in array
        int[] array = new int[] {1, 2, 3, 4, 5};

        int[] evenArray  = Arrays.stream(array)
                .filter(a -> a % 2 == 0)
                .toArray();

    }
}
