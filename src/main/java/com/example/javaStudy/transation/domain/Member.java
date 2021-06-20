package com.example.javaStudy.transation.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 30)
    private String nickname;
    @Column(nullable = false, length = 100)
    private String email;
    @CreationTimestamp
    @Column(name = "create_dt")
    private LocalDateTime createDt; // 생성일시
    @UpdateTimestamp
    @Column(name = "update_dt")
    private LocalDateTime updateDt; // 수정일시

    @Builder(buildMethodName = "memberMakeSample")
    private Member(String name, String nickname, String email) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }
}
