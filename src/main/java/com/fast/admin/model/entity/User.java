package com.fast.admin.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderGroupList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'User Index'")
    private Long id;

    @Column(columnDefinition = "VARCHAR(12) COMMENT '계정'", nullable = false)
    private String account;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '비밀번호'", nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '회원상태'", nullable = false)
    private String status;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '이메일'")
    private String email;

    @Column(columnDefinition = "VARCHAR(13) COMMENT '전화번호'")
    private String phoneNumber;

    @Column(columnDefinition = "DATETIME COMMENT '가입 일자'", nullable = false)
    private LocalDateTime registeredAt;

    @Column(columnDefinition = "DATETIME COMMENT '해지 일자'")
    private LocalDateTime unregisteredAt;

    @CreatedDate
    @Column(columnDefinition = "DATETIME COMMENT '생성 일자'", nullable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(columnDefinition = "VARCHAR(20) COMMENT '생성 자'", nullable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(columnDefinition = "DATETIME COMMENT '수정 일자'")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(columnDefinition = "VARCHAR(20) COMMENT '수정 자'")
    private String updatedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
}
