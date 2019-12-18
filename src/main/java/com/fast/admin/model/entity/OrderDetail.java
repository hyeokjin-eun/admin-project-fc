package com.fast.admin.model.entity;

import com.fast.admin.model.enumClass.OrderStatus;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderGroup", "item"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20) COMMENT 'OrderDetail Index'")
    private Long id;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '주문상태'")
    private OrderStatus status;

    @Column(columnDefinition = "DATETIME COMMENT '도착 예정 일자'")
    private LocalDateTime arrivalDate;

    @Column(columnDefinition = "INT COMMENT '주문 수량'")
    private Integer quantity;

    @Column(columnDefinition = "DECIMAL(12,4) COMMENT '주문 총 금액'")
    private BigDecimal totalPrice;

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
    private OrderGroup orderGroup;

    @ManyToOne
    private Item item;
}
