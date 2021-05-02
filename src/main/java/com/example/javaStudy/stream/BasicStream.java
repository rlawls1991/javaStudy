package com.example.javaStudy.stream;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.*;
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
        // int count = list2.stream().count();

        System.out.println();

        // 3. 최정 연상 전까지 중간연산이 수행하지 않는다.
        IntStream intStream = new Random().ints(1,46);
        intStream.distinct().limit(6).sorted()
                .forEach(i -> System.out.println("i : " + i));
    }


    /**
     * 스트림 자르기
     * limit, skip
     */
    public void example1(){
        IntStream intStream = IntStream.range(1,100);
        intStream.skip(3).limit(5)
                .forEach(System.out::print);
        System.out.println();
    }

    /**
     * 스트림의 요소 걸러내기
     * distinct, filter
     */
    public void example2(){
        // distinct
        IntStream intStream = IntStream.of(1,1,2,3,4,3,2,2,2,2,2,3,6,7,8,9);
        intStream.distinct()
                .forEach(System.out::print);
        System.out.println();

        // filter
        IntStream rangeIntStream = IntStream.rangeClosed(1,10);
        rangeIntStream.filter(i -> i % 2 == 0)
                .forEach(System.out::print);
        System.out.println();

        IntStream rangeIntStream2 = IntStream.rangeClosed(1,20);
        rangeIntStream2.filter(i -> i % 2 == 0 && i > 10)
                .forEach(i -> System.out.print(" " + i));
        System.out.println();
    }

    /**
     * 스트림 정렬
     */
    public void example3(){
        // 아래 두개는 같은 기능을 나눈 것!!
        // 전자가 더 쉽게 알 수가 있다.
        List<String> stringList = Arrays.asList("a", "B", "C", "D", "E", "a", "c", "d");
        stringList.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(i -> System.out.print(" "+ i));
        System.out.println();

        stringList.stream()
                .sorted((first, second) -> {
                    int res = first.compareToIgnoreCase(second);
                    return (res == 0) ? first.compareTo(second) : res;
                 })
                .forEach(i -> System.out.print(" "+ i));
        System.out.println();


        // reversed 사용
        stringList.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .forEach(i -> System.out.print(" "+ i));
        System.out.println();


        List<TestVO> list = returnSampleData();
        list.stream()
            .sorted(Comparator.comparing(TestVO::getName)
                .thenComparing(TestVO::getAge)
                .thenComparing(TestVO::getNickName))
                .forEach(i -> System.out.println(" "+ i.toString()));
        System.out.println();
    }


    private List<TestVO> returnSampleData(){
        List<TestVO> returnValue = new ArrayList<>();
        TestVO addValue = TestVO.builder()
                .name("김종국")
                .nickName("가")
                .age(3)
                .build();
        TestVO addValue2 = TestVO.builder()
                .name("김종국")
                .nickName("다")
                .age(2)
                .build();
        TestVO addValue3 = TestVO.builder()
                .name("송지효")
                .nickName("나")
                .age(2)
                .build();
        TestVO addValue4 = TestVO.builder()
                .name("양세형")
                .nickName("나")
                .age(10)
                .build();
        TestVO addValue5 = TestVO.builder()
                .name("유재석")
                .nickName("라")
                .age(1)
                .build();
        TestVO addValue6 = TestVO.builder()
                .name("양세형")
                .nickName("마")
                .age(10)
                .build();


        returnValue.add(addValue);
        returnValue.add(addValue2);
        returnValue.add(addValue3);
        returnValue.add(addValue4);
        returnValue.add(addValue5);
        returnValue.add(addValue6);

        return returnValue;
    }



    @Data
    @Builder
    @ToString
    private static class TestVO{
        private String name;
        private String nickName;
        private int age;
    }
}
