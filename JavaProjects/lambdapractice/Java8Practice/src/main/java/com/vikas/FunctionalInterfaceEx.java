package com.vikas;

import javax.jws.Oneway;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaceEx {

    public static void main(String[] args) {
        List<Integer> integerList= Arrays.asList(1,2,3,4);
//        integerList.stream().filter(n->n%2==0).map(x->x*x).forEach(x->System.out.println(x));
//        //simplified form of lambda expression is Method reference as shown below
//        integerList.stream().filter(n->n%2==0).forEach(System.out::println);
        integerList.stream().filter(integerPredicate)
        .map(integerFunction).forEach(consumer);
//supplier example
        Arrays.asList(citySupplier.get()).forEach(System.out::println);

        System.out.println(integerList.stream().reduce(0,IntegerBinaryOperator));

        UnaryOperator<Integer> unaryOperator= (x)->3*x;

        System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer,String> biPredicate=(a, str) -> {
         return a>5 && str.length()>5;
        };

        System.out.println(biPredicate.test(6,"Jhonny"));

        BiFunction<Integer,String,String> biFunction=(a, str) ->{
          return a+" "+str;
        };

        System.out.println(biFunction.apply(20,"Somu"));

        BiConsumer<Integer,String> biConsumer=(a,str)->{
            System.out.println(a);
            System.out.println(str);
        };
       biConsumer.accept(10,"Ramu");

    }

    private static BinaryOperator<Integer> IntegerBinaryOperator=new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a+b;
        }
    };

    public static Predicate<Integer> integerPredicate= new Predicate<Integer>() {
        @Override
        public boolean test(Integer num) {
            return num%2==0;
        }
    };

    private static Function<Integer, Integer> integerFunction= new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer num) {
            return num*num;
        }
    };

    private static Consumer<Integer> consumer=new Consumer<Integer>() {
        @Override
        public void accept(Integer num) {
            System.out.println(num);
        }
    };

    public static Supplier<String[]> citySupplier = new Supplier<String[]>() {
        @Override
        public String[] get() {
            return new String[]{"Mumbai", "Delhi", "Goa", "Pune"};
        }
    };



}
