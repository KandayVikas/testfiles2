package com.vikas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FPWithCustomClass {


    public static void main(String[] args) {

        List<Course> courseList= Arrays.asList(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        Predicate<Course> predicatewithScoreGreaterThan90=course -> course.getScore()>90 ;

        // allMatch, noneMatch, anyMatch
        System.out.println(courseList.stream().allMatch(predicatewithScoreGreaterThan90));
        System.out.println(courseList.stream().noneMatch(course -> course.getScore()>100));
        System.out.println(courseList.stream().anyMatch(course -> course.getScore()>90));

        //sorted and use with comparator
        //use comparingInt as it is best to use for primitive type int bcz boxing & unboxing effect the performance
        System.out.println(courseList.stream().sorted(Comparator.comparingInt(Course::getScore)).collect(Collectors.toList()));
        System.out.println(courseList.stream().sorted(Comparator.comparingInt(Course::getScore).reversed()).collect(Collectors.toList()));
        System.out.println(courseList.stream().sorted(Comparator.comparing(Course::getName)).collect(Collectors.toList()));
        System.out.println(courseList.stream().sorted(Comparator.comparing(Course::getName).reversed()).collect(Collectors.toList()));

        //if both noofstudents equal thencompare with score
        Comparator<Course> comparingByNoOfStudentsAndScore =
                Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getScore);
        System.out.println(courseList.stream().sorted(comparingByNoOfStudentsAndScore).collect(Collectors.toList()));

        //prints first 3 records as we used limit(3)
        System.out.println(courseList.stream().sorted(comparingByNoOfStudentsAndScore).limit(3).collect(Collectors.toList()));
        //skips first 3 records and prints all remaining as we used skip(3)
        System.out.println(courseList.stream().sorted(comparingByNoOfStudentsAndScore).skip(3).collect(Collectors.toList()));
        //skips first 3 records and prints next 3 recs skip(3) & limit(3)
        System.out.println(courseList.stream().sorted(comparingByNoOfStudentsAndScore).skip(3).limit(3).collect(Collectors.toList()));

        //min & max
        System.out.println(courseList.stream().filter(course -> course.getScore()>90).max(Comparator.comparingInt(Course::getScore)));
        // will return optional Optional[Course{name='Azure', category='Cloud', score=99, noOfStudents=21000}]
        System.out.println(courseList.stream().filter(course -> course.getScore()>100).max(Comparator.comparingInt(Course::getScore)));
        // Optional.empty
        System.out.println(courseList.stream().filter(course -> course.getScore()>100)
                .max(Comparator.comparingInt(Course::getScore)).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
        //Course{name='Kubernetes', category='Cloud', score=91, noOfStudents=20000}

        System.out.println(courseList.stream().filter(course -> course.getScore()>90).min(Comparator.comparingInt(Course::getScore)));

        //findFirst
        System.out.println(courseList.stream().filter(course -> course.getScore()>90).findFirst());
        //findAny
        System.out.println(courseList.stream().filter(course -> course.getScore()>90).findAny());

        //sum,average,count
        //mapToInt as it is primitive
        System.out.println(courseList.stream().mapToInt(Course::getScore).sum());

        System.out.println(courseList.stream().mapToInt(Course::getScore).average());

        System.out.println(courseList.stream().filter(predicatewithScoreGreaterThan90).mapToInt(Course::getScore).count());

        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory)));
        //{Cloud=[Course{name='AWS', category='Cloud', score=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', score=99, noOfStudents=21000}, Course{name='Docker', category='Cloud', score=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', score=91, noOfStudents=20000}],
        // FullStack=[Course{name='FullStack', category='FullStack', score=91, noOfStudents=14000}],......etc

        System.out.println(
                courseList.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
       // {Cloud=4, FullStack=1, Microservices=2, Framework=2}

        //group by category then max by score returns just max one record in that group
        System.out.println(courseList.stream()
                .collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(Comparator.comparing(Course::getScore)))));
            //{Cloud=Optional[Course{name='Azure', category='Cloud', score=99, noOfStudents=21000}],
           // FullStack=Optional[Course{name='FullStack', category='FullStack', score=91, noOfStudents=14000}],
          // Microservices=Optional[Course{name='API', category='Microservices', score=97, noOfStudents=22000}],
          // Framework=Optional[Course{name='Spring', category='Framework', score=98, noOfStudents=20000}]}

        System.out.println(courseList.stream()
                .collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList()))));

        //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}



    }
}
