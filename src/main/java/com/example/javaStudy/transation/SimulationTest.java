package com.example.javaStudy.transation;

import org.springframework.transaction.annotation.Transactional;

public class SimulationTest {

    public void inDirectException() throws Exception {
        throw new Exception("간접 처리 방식 !");
    }

    public void callInDirectException() {
        try {
            System.out.println("여기는 call");
            inDirectException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void directException() {
        try {
            System.out.println("Exception 이 발생하지 않는다면 실행하는 공간!.");
            throw new Exception("직접 처리 방식");
        } catch (Exception e) {
            System.out.println("Exception 발생하면 실행 : " + e.getMessage());
        } finally {
            System.out.println("무조건 실행");
        }
    }
}
