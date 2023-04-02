package com.vikas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FPWithFiles {
    public static void main(String[] args) throws IOException {
        //prints the content of file line by line
        Files.lines(Paths.get("file.txt")).forEach(System.out::println);

        //To print word by word
        //.map returns array of strings then by flatmap we are converting single stream with strings
        Files.lines(Paths.get("file.txt")).map(s->s.split(" "))
                .flatMap(Arrays::stream).forEach(System.out::println);

        //To print distinct words with sorted order
        Files.lines(Paths.get("file.txt")).map(s->s.split(" "))
                .flatMap(Arrays::stream).distinct().sorted().forEach(System.out::println);

        //print all files present from the root folder here
        Files.list(Paths.get(".")).forEach(System.out::println);

        //filter with only directories
        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

    }
}
