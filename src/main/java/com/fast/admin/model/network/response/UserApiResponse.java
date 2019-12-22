package com.fast.admin.model.network.response;

import com.fast.admin.model.enumClass.UserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "UserApiResponse", description = "사용자 응답 모델")
public class UserApiResponse {

    @ApiModelProperty(value = "사용자 식별자")
    private Long id;

    @ApiModelProperty(value = "사용자 계정")
    private String account;

    @ApiModelProperty(value = "사용자 비밀번호")
    private String password;

    @ApiModelProperty(value = "사용자 상태")
    private UserStatus status;

    @ApiModelProperty(value = "사용자 이메일")
    private String email;

    @ApiModelProperty(value = "사용자 전화번호")
    private String phoneNumber;

    @ApiModelProperty(value = "사용자 등록일자")
    private LocalDateTime registeredAt;

    @ApiModelProperty(value = "사용자 해지일자")
    private LocalDateTime unregisteredAt;

    @ApiModelProperty(value = "주문 묶음 목록")
    private List<OrderGroupApiResponse> orderGroupApiResponseList;
}
