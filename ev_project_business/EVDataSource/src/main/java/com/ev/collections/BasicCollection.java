package com.ev.collections;

import com.ev.domain.Employee;

import java.util.*;

public class BasicCollection {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(7,6,3,4,5,1,2);
        integerList.sort(Integer::compare);
        //System.out.println(integerList);

        String firstName = "abc";
        String lastName = "abc";
        //System.out.println(firstName.compareTo(lastName));


        Set<String> names = new TreeSet<>();
        names.add("leo");
        names.add("vendetta");
        names.add("apple");

        System.out.println(names);
    }
}
