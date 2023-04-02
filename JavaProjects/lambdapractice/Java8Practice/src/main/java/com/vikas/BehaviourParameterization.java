package com.vikas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviourParameterization {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);
        //list.stream().filter(x->x%2==0).forEach(System.out::println);
        //step 1: copy this x->x%2==0 right click & introduce to a local variable
        //step 2: cpy this list.stream().filter(x->x%2==0).forEach(System.out::println);
        //right click & introduce method
        //step 3:getCollect(list,res); copy res & right click make inline

        filterAndPrint(list, x -> x % 2 != 0);
        //we are passing behaviour as a parameter in method so that we can easily change this behaviour
        //List<Integer> list1=list.stream().map(x->x*x).collect(Collectors.toList());
        List<Integer> list1= getCollect(list, x -> x * x);
        List<Integer> list2= getCollect(list, x -> x * x * x);

    }

    private static List<Integer> getCollect(List<Integer> list, Function<Integer, Integer> integerIntegerFunction) {
        return list.stream().map(integerIntegerFunction).collect(Collectors.toList());
    }


    private static void filterAndPrint(List<Integer> list, Predicate<Integer> integerPredicate) {
        list.stream().filter(integerPredicate).forEach(System.out::println);
    }
}
