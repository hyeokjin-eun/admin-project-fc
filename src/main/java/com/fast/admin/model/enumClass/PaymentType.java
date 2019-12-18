package com.fast.admin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {

    CARD(0, "카드", "결제 수단 카드"),
    CASH(1, "현금", "결제 수단 현금");

    private Integer id;

    private String title;

    private String description;
}
