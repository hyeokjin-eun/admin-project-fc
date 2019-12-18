package com.fast.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'AdminUser Index'")
    private Long id;

    @Column(columnDefinition = "VARCHAR(12) COMMENT '계정'")
    private String account;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '비밀번호'")
    private String password;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '회원 상태'")
    private String status;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '회원 권한'")
    private String role;

    @Column(columnDefinition = "DATETIME COMMENT '마지막 접근 일자'")
    private LocalDateTime lastLoginAt;

    @Column(columnDefinition = "DATETIME COMMENT '비밀번호 갱신 일자'")
    private LocalDateTime passwordUpdatedAt;

    @Column(columnDefinition = "INT COMMENT '비밀번호 실패 이력'")
    private int loginFailCount;

    @Column(columnDefinition = "DATETIME COMMENT '가입 일자'")
    private LocalDateTime registeredAt;

    @Column(columnDefinition = "DATETIME COMMENT '해지 일자'")
    private LocalDateTime unregisteredAt;

    @CreatedDate
    @Column(columnDefinition = "DATETIME COMMENT '생성 일자'")
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(columnDefinition = "VARCHAR(20) COMMENT '생성 자'")
    private String createdBy;

    @LastModifiedDate
    @Column(columnDefinition = "DATETIME COMMENT '수정 일자'")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(columnDefinition = "VARCHAR(20) COMMENT '수정 자'")
    private String updatedBy;
}
