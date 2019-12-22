package com.fast.admin.model.network.response;

import com.fast.admin.model.enumClass.OrderStatus;
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
@ApiModel(value = "OrderDetailApiResponse", description = "주문 응답 모델")
public class OrderDetailApiResponse {

    @ApiModelProperty(value = "주문 식별자")
    private Long id;

    @ApiModelProperty(value = "주문 상태")
    private OrderStatus status;

    @ApiModelProperty(value = "도착 일자")
    private LocalDateTime arrivalDate;

    @ApiModelProperty(value = "주문 총 수")
    private Integer quantity;

    @ApiModelProperty(value = "주문 총 가격")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "주문 묶음 식별자")
    private Long orderGroupId;

    @ApiModelProperty(value = "상품 식별자")
    private Long itemId;
}
