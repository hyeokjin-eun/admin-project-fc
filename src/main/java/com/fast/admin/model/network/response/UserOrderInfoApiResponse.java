package com.fast.admin.model.network.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "UserOrderInfoApiResponse", description = "유저 주문 목록 응답 모델")
public class UserOrderInfoApiResponse {

    @ApiModelProperty(value = "유저 정보")
    private UserApiResponse userApiResponse;
}
