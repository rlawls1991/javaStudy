package com.example.javaStudy.transation;

import com.example.javaStudy.transation.domain.Member;
import com.example.javaStudy.transation.repository.MemberRepository;
import com.example.javaStudy.transation.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SpringTransaction {

    private final MemberRepository memberRepository;
    private final SampleRepository sampleRepository;

    /**
     * 직접 처리 방식내에서 오류가 발생 할 때 Transaction 처리 여부 확인
     * @throws Exception
     */
    @Transactional
    public void simulation1() throws Exception {
        Member member1 = Member.builder()
                .name("Member1")
                .nickname("닉테임1")
                .email("test1@test.com")
                .memberMakeSample();
        Member member2 = Member.builder()
                .name("Member2")
                .nickname("닉테임2")
                .email("test2@test.com")
                .memberMakeSample();

        memberRepository.save(member1);

        try {
            sampleRepository.failMethod();
            memberRepository.save(member2);
        } catch (Exception e) {
            System.out.println("에러 발생!1!!!");
        }

        /*
        Member가 저장이 되어 있다면 해당 ID들은 저장이 되어있을 것
         */
        System.out.println("member1 id : " + member1.getMemberId());
        System.out.println("member2 id : " + member2.getMemberId());
    }


    /**
     * 간접 처리 방식내에서 오류가 발생 할 때 Transaction 처리 여부 확인
     * @throws Exception
     */
    @Transactional
    public void simulation2() throws Exception {
        Member member1 = Member.builder()
                .name("Member1")
                .nickname("닉테임1")
                .email("test1@test.com")
                .memberMakeSample();

        Member member2 = Member.builder()
                .name("Member2")
                .nickname("닉테임2")
                .email("test2@test.com")
                .memberMakeSample();

        memberRepository.save(member1);
        sampleRepository.failMethod();
        memberRepository.save(member2);

        /*
        Member가 저장이 되어 있다면 해당 ID들은 저장이 되어있을 것
         */
        System.out.println("member1 id : " + member1.getMemberId());
        System.out.println("member2 id : " + member2.getMemberId());
    }


    /**
     * @Transactional(rollbackFor = Exception.class) 옵션 먹힘
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void simulation3() throws Exception {
        Member member1 = Member.builder()
                .name("Member1")
                .nickname("닉테임1")
                .email("test1@test.com")
                .memberMakeSample();
        Member member2 = Member.builder()
                .name("Member2")
                .nickname("닉테임2")
                .email("test2@test.com")
                .memberMakeSample();

        memberRepository.save(member1);

        try {
            sampleRepository.failMethod();
            memberRepository.save(member2);
        } catch (Exception e) {
            System.out.println("에러 발생!1!!!");
        }

        /*
        Member가 저장이 되어 있다면 해당 ID들은 저장이 되어있을 것
         */
        System.out.println("member1 id : " + member1.getMemberId());
        System.out.println("member2 id : " + member2.getMemberId());
    }


    /**
     * @Transactional(rollbackFor = Exception.class) 옵션 안먹힘
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void simulation4() throws Exception {
        Member member1 = Member.builder()
                .name("Member1")
                .nickname("닉테임1")
                .email("test1@test.com")
                .memberMakeSample();
        Member member2 = Member.builder()
                .name("Member2")
                .nickname("닉테임2")
                .email("test2@test.com")
                .memberMakeSample();

        memberRepository.save(member1);

        try {
            sampleRepository.failMethod();
            memberRepository.save(member2);
        } catch (Exception e) {
            throw new Exception();
        }

        /*
        Member가 저장이 되어 있다면 해당 ID들은 저장이 되어있을 것
         */
        System.out.println("member1 id : " + member1.getMemberId());
        System.out.println("member2 id : " + member2.getMemberId());
    }

}
