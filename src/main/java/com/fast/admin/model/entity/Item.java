package com.fast.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'Item Index'")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '상품상태'")
    private String status;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '상품 명'")
    private String name;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '상품타이틀'")
    private String title;

    @Column(columnDefinition = "TEXT COMMENT '상품 내용'")
    private String content;

    @Column(columnDefinition = "DECIMAL(12,4) COMMENT '가격'")
    private Integer price;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '브랜드 명'")
    private String brandName;

    @Column(columnDefinition = "DATETIME COMMENT '상품 등록 일자'")
    private LocalDateTime registeredAt;

    @Column(columnDefinition = "DATETIME COMMENT '상품 해지 일자'")
    private LocalDateTime unregisteredAt;

    @Column(columnDefinition = "DATETIME COMMENT '생성 일자'")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '생성 자'")
    private String createdBy;

    @Column(columnDefinition = "DATETIME COMMENT '수정 일자'")
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '수정 자'")
    private String updatedBy;

    private Long partnerId;
}
