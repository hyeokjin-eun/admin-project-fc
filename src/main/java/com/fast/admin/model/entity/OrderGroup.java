package com.fast.admin.model.entity;

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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString(exclude = {"user", "orderDetailList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'OrderGroup Index'")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '주문 상태'")
    private String status;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '주문 타임(일괄, 개별)'")
    private String orderType;

    @Column(columnDefinition = "TEXT COMMENT '배송지 주소'")
    private String revAddress;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '수령인'")
    private String revName;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '납부 방법'")
    private String paymentType;

    @Column(columnDefinition = "DECIMAL(12,4) COMMENT '전체 금액'")
    private BigDecimal totalPrice;

    @Column(columnDefinition = "INT COMMENT '전체 수량'")
    private Integer totalQuantity;

    @Column(columnDefinition = "DATETIME COMMENT '주문 일자'")
    private LocalDateTime orderAt;

    @Column(columnDefinition = "DATETIME COMMENT '도착 예정 일자'")
    private LocalDateTime arrivalDate;

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
    @Column(columnDefinition = "VARCHAR(20) COMMENT '수정자'")
    private String updatedBy;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
}
