package com.ev.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsIntro {
    /**
     * create streams
     */
    public static void main(String[] args) {
        Consumer<String> stringConsumer = (str)-> System.out.println(str);
        Function<String,String> function = (a)->a.toUpperCase();
        Predicate<String> predicate = (str)->str.length()>3;

        Set<String> strings =Stream.of("abc","abc","efgk","hij1")
                .map(function)
                .collect(Collectors.toSet());

        Optional<Integer> result = List.of(1,2,3,4,5,6,7,8,9,10)
                .stream()
                .distinct()
                .reduce((a,b)->a+b);
        System.out.println(result);

        /**
         * Interview question
         * Given a String, count the repetitive characters with in it
         */
        String sentence = "hhey how u doing !";
        var resultValues = Arrays.stream(sentence.split(""))
                .filter(str-> !Pattern.compile("[\\s+!]").matcher(str).matches())
                .collect(Collectors.groupingBy(a->a,Collectors.counting()));
        System.out.println(resultValues.entrySet());

        Map<String, Integer> map = new HashMap<>();
        String[] strs = sentence.split("");
        for(int i = 0; i < strs.length ; i++){
            if(!Pattern.compile("[\\s+!]").matcher(strs[i]).matches()){
                if(map.containsKey(strs[i])){
                    map.put(strs[i],map.get(strs[i])+1);
                }else{
                    map.put(strs[i],1);
                }
            }
        }

        System.out.println(map.entrySet());
    }
}
