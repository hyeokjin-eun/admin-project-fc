package com.fast.admin.model.entity;

import com.fast.admin.model.enumClass.ItemStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"orderDetailList", "partner"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'Item Index'")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50) COMMENT '상품상태'")
    private ItemStatus status;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '상품 명'")
    private String name;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '상품타이틀'")
    private String title;

    @Column(columnDefinition = "TEXT COMMENT '상품 내용'")
    private String content;

    @Column(columnDefinition = "DECIMAL(12,4) COMMENT '가격'")
    private BigDecimal price;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '브랜드 명'")
    private String brandName;

    @Column(columnDefinition = "DATETIME COMMENT '상품 등록 일자'")
    private LocalDateTime registeredAt;

    @Column(columnDefinition = "DATETIME COMMENT '상품 해지 일자'")
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
    private Partner partner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
