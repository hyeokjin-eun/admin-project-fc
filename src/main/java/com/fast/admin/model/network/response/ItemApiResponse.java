package com.fast.admin.model.network.response;

import com.fast.admin.model.enumClass.ItemStatus;
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
@ApiModel(value = "ItemApiResponse", description = "상품 응답 모델")
public class ItemApiResponse {

    @ApiModelProperty(value = "상품 식별자")
    private Long id;

    @ApiModelProperty(value = "상품 상태")
    private ItemStatus status;

    @ApiModelProperty(value = "상품 명")
    private String name;

    @ApiModelProperty(value = "상품 제목")
    private String title;

    @ApiModelProperty(value = "상품 내용")
    private String content;

    @ApiModelProperty(value = "상품 가격")
    private BigDecimal price;

    @ApiModelProperty(value = "브랜드 명")
    private String brandName;

    @ApiModelProperty(value = "등록 일자")
    private LocalDateTime registeredAt;

    @ApiModelProperty(value = "해지 일자")
    private LocalDateTime unregisteredAt;

    @ApiModelProperty(value = "파트너 식별자")
    private Long partnerId;
}
