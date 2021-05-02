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
}