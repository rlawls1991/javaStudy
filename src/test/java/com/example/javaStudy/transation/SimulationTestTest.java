package com.example.javaStudy.transation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimulationTestTest {
    SimulationTest simulationTest = new SimulationTest();

    @Test
    @DisplayName("직접 처리 방식")
    void directException(){
        simulationTest.directException();
    }

    @Test
    @DisplayName("간접 처리 방식")
    void inDirectException(){
        simulationTest.callInDirectException();
    }
}