package com.example.javaStudy.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicStreamTest {

    private static BasicStream basicStream = new BasicStream();

    @Test
    @DisplayName("스트림은 무엇인가? ")
    void whatIsStream() {
        basicStream.whatIsStream();
    }

    @Test
    void orderOfAction() {
        basicStream.StreamCharacteristic();
    }

    @Test
    void examples(){
        System.out.println("1=============================");
        basicStream.example1();
        System.out.println("2==============================");
        basicStream.example2();
        System.out.println("3==============================");
        basicStream.example3();
        System.out.println("4==============================");
        basicStream.example4();
        System.out.println("5==============================");
        basicStream.example5();
    }
}