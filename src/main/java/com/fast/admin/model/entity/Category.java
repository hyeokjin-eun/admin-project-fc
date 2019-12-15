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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'Category Index'")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '카테고리 타입'", nullable = false)
    private String type;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '카테고리 명'", nullable = false)
    private String title;

    @Column(columnDefinition = "DATETIME COMMENT '생성 일자'", nullable = false)
    private LocalDateTime createdAt;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '생성 자'", nullable = false)
    private String createdBy;

    @Column(columnDefinition = "DATETIME COMMENT '수성 일자'")
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "VARCHAR(20) COMMENT'수정자'")
    private String updatedBy;
}
