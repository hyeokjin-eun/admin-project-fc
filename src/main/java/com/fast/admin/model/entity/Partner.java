package com.fast.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"itemList", "category"})
@EntityListeners(AuditingEntityListener.class)
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

    @ManyToOne
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> itemList;
}
