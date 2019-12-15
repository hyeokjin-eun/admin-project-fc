package com.fast.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'Partner Index'")
    private Long id;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '파트너사 이름'")
    private String name;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '파트너사 상태'")
    private String status;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '파트너사 주소'")
    private String address;

    @Column(columnDefinition = "VARCHAR(13) COMMENT '고객센터 전화번호'")
    private String callCenter;

    @Column(columnDefinition = "VARCHAR(13) COMMENT '담당자 전화번호'")
    private String partnerNumber;

    @Column(columnDefinition = "VARCHAR(16) COMMENT '사업자 등록 번호'")
    private String businessNumber;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '대표자 성함'")
    private String ceoName;

    @Column(columnDefinition = "DATETIME COMMENT '가입 일자'")
    private LocalDateTime registeredAt;

    @Column(columnDefinition = "DATETIME COMMENT '해지 일자'")
    private LocalDateTime unregisteredAt;

    @Column(columnDefinition = "DATETIME COMMENT '생성 일자'")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '생성 자'")
    private String createdBy;

    @Column(columnDefinition = "DATETIME COMMENT '수정 일자'")
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '수정 자'")
    private String updatedBy;

    private Long categoryId;
}
