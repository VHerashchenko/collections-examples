package com.vh;

import com.vh.array.Simple;
import com.vh.array.impl.SimpleArray;
import com.vh.linkedList.Linked;
import com.vh.linkedList.impl.LinkedContainer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class App {

    public static void main( String[] args ) {

        Simple<String> simpleArray = new SimpleArray<>();

        simpleArray.add("first");
        simpleArray.add("second");
        simpleArray.add("third");
        simpleArray.add("fourth");

        simpleArray.update(1, "updated");
        simpleArray.remove(2);

        for(String s : simpleArray){
            System.out.println(s);
        }

        System.out.println("=================================");

        Linked<String> stringLinked = new LinkedContainer<>();

        stringLinked.addLast("lastString");
        stringLinked.addFirst("firstString");
        stringLinked.addFirst("sameFirst");


        for(String s : stringLinked){
            System.out.println(s);
        }

        System.out.println("=================================");

        List<Integer> arrayList = Arrays.asList(4,5,-6,4,5,3,4,2,4,5,7);

        Map<Integer,Long> hashMap = arrayList.stream()
                .collect(groupingBy(Function.identity(), counting()));

        hashMap.entrySet().forEach(System.out::println);

        System.out.println("=================================");

        double average = arrayList.stream()
                .mapToDouble(value -> (double) value)
                .average()
                .orElse(Double.NaN);

        System.out.println(average);

        System.out.println("=================================");

        IntStream.range(0, arrayList.size())
                .reduce((a,b) -> arrayList.get(a) > arrayList.get(b) ? b : a)
                .ifPresent(i -> System.out.println("Index " + i + ", MinValue " + arrayList.get(i)));

        System.out.println("=================================");

        long countNull = arrayList.stream()
                .filter(x -> x == 0)
                .count();

        System.out.println(countNull);

        System.out.println("=================================");

        long countBiggerNull = arrayList.stream()
                .filter(x -> x > 0)
                .count();

        System.out.println(countBiggerNull);

        System.out.println("=================================");

        int number = 2;

        arrayList.stream()
                .map(v -> v * number)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}