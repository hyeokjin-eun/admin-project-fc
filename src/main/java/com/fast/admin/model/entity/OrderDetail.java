package com.fast.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'OrderDetail Index'")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '주문상태'")
    private String status;

    @Column(columnDefinition = "DATETIME COMMENT '도착 예정 일자'")
    private LocalDateTime arrivalDate;

    @Column(columnDefinition = "INT COMMENT '주문 수량'")
    private Integer quantity;

    @Column(columnDefinition = "DECIMAL(12,4) COMMENT '주문 총 금액'")
    private BigDecimal totalPrice;

    @Column(columnDefinition = "DATETIME COMMENT '생성 일자'")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '생성 자'")
    private String createdBy;

    @Column(columnDefinition = "DATETIME COMMENT '수정 일자'")
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '수정 자'")
    private String updatedBy;

    private Long orderGroupId;

    private Long itemId;
}
