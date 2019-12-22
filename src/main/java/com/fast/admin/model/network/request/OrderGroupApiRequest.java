package com.fast.admin.model.network.request;

import com.fast.admin.model.enumClass.OrderStatus;
import com.fast.admin.model.enumClass.OrderType;
import com.fast.admin.model.enumClass.PaymentType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "OrderGroupApiRequest", description = "주문묶음 요청 모델")
public class OrderGroupApiRequest {

    @ApiModelProperty(value = "주문묶음 식별자")
    private Long id;

    @ApiModelProperty(value = "주문묶음 상태")
    private OrderStatus status;

    @ApiModelProperty(value = "주문 유형")
    private OrderType orderType;

    @ApiModelProperty(value = "수령 주소")
    private String revAddress;

    @ApiModelProperty(value = "수령인")
    private String revName;

    @ApiModelProperty(value = "결제 유형")
    private PaymentType paymentType;

    @ApiModelProperty(value = "주문 총 금액")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "주문 총 수")
    private Integer totalQuantity;

    @ApiModelProperty(value = "주문일자")
    private LocalDateTime orderAt;

    @ApiModelProperty(value = "도착일자")
    private LocalDateTime arrivalDate;

    @ApiModelProperty(value = "사용자 식별자")
    private Long userId;
}
