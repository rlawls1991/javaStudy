package com.example.javaStudy.stream;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicStream {


    /**
     * 아래의 코드를 실행시키게 된다면 <br />
     * stream 안쪽에 있는 값이 들어가 있지 않을 것이다.
     * 그 이유는 스트림을 사용할라면
     * 1. 스트림 만들기
     * 2. 중간연상
     * 3. 최종연산을
     * 위 3가지의 조건을 만족시켜야 하는데 현재 1,2단계만 만족했기 때문이다.
     */
    public void whatIsStream() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> intStream = list.stream();
        Stream<String> stringStream = Stream.of(new String[]{"a","b","c"});
        Stream<Integer> eventStream = Stream.iterate(0, n -> n + 2).limit(10);
        Stream<Double> randomStream = Stream.generate(Math::random);
        IntStream randomIntStream = new Random().ints(5);

        System.out.println("intStream : " + intStream);
        System.out.println("stringStream : " + stringStream);
        System.out.println("eventStream : " + eventStream);
        System.out.println("randomStream : " + randomStream);
        System.out.println("randomIntStream : " + randomIntStream);
    }

    /**
     * 스트림 특징
     * 1. 스트림은 데이터 소스로부터 데이터를 읽기만 할뿐 변경하지 않는다.
     * 2. 스트림은 lterator 처럼 일회용이다.
     * 3. 최종 연산 전까지 중간연상이 수행하지 않는다.
     *  - 지연된 연상
     */
    public void StreamCharacteristic() {
        // 1. 스트림은 데이터 소스로부터 데이터를 읽기만 할뿐 변경하지 않는다.
        List<Integer> list = Arrays.asList(13, 21, 23, 74, 5,26, 71, 18, 96);
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("list : " + list);
        System.out.println("sortedList : " + sortedList);

        // 2. 스트림은 lterator 처럼 일회용이다.
        List<Integer> list2 = Arrays.asList(13, 21, 23, 74, 5,26, 71, 18, 96);
        list2.stream().forEach(System.out::print);
        // 아래 코드는 에러가 발생이 된다.
        // 그 이유는 이미 위에서 forEach를 사용해서 최종연산을 행하였기 때문이다.
        //int count = list2.stream().count();

        System.out.println();

        // 3. 최정 연상 전까지 중간연산이 수행하지 않는다.
        IntStream intStream = new Random().ints(1,46);
        intStream.distinct().limit(6).sorted()
                .forEach(i -> System.out.println("i : " + i));

    }

}
