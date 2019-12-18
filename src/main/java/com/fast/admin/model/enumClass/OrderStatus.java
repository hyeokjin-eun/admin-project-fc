package com.fast.admin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    COMPLETE(0, "배송 완료", "주문 배송 완료 상태"),
    DELIVERY(1, "배송 중", "주문 배송 중 상태"),
    WAITING(2, "준비 중", "주문 준비 중 상태");

    private Integer id;

    private String title;

    private String description;
}
