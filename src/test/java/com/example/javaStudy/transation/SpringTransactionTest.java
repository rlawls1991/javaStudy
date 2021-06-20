package com.example.javaStudy.transation;

import com.example.javaStudy.transation.domain.Member;
import com.example.javaStudy.transation.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringTransactionTest {

    @Autowired
    private SpringTransaction springTransaction;

    @Autowired
    private MemberRepository memberRepository;


    @Test
    @DisplayName("직접 처리 방식내에서 오류가 발생 할 때 Transaction 처리 여부 확인")
    void simulation1() throws Exception {
        springTransaction.simulation1();

        List<Member> list = memberRepository.findAll();
        for(Member member : list){
            System.out.println(member.toString());
        }
    }

    @Test
    @DisplayName("간접 처리 방식내에서 오류가 발생 할 때 Transaction 처리 여부 확인")
    void simulation2() throws Exception {
        springTransaction.simulation2();

        System.out.println("테스트 조회 시작");
        List<Member> list = memberRepository.findAll();
        for(Member member : list){
            System.out.println(member.toString());
        }
    }

    @Test
    @DisplayName(" @Transactional(rollbackFor = Exception.class) 옵션 안먹힘...")
    void simulation3() throws Exception {
        springTransaction.simulation3();

        List<Member> list = memberRepository.findAll();
        for(Member member : list){
            System.out.println(member.toString());
        }
    }


    @Test
    @DisplayName(" @Transactional(rollbackFor = Exception.class) 옵션 먹힘")
    void simulation4() throws Exception {
        springTransaction.simulation4();

        List<Member> list = memberRepository.findAll();
        for(Member member : list){
            System.out.println(member.toString());
        }
    }
}