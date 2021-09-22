package com.vh;

import com.vh.array.Simple;
import com.vh.array.impl.SimpleArray;
import com.vh.linkedList.Linked;
import com.vh.linkedList.impl.LinkedContainer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
    }
}