package com.example.javaStudy.transation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository {
    public void successMethod(){
        System.out.println("성공 Repsitory");
    }

    public void failMethod() throws Exception {
        System.out.println("실패 Repository");
        throw new Exception();
    }
}
